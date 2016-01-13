package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sm.framework.model.dao.impl.OrgTypeDAO;
import com.sm.framework.model.dao.impl.OrgTypeDAOImpl;
import com.sm.framework.model.entity.OrgType;



public class OrgTypeModifyAction implements FunctionAction, ActionListener {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel= null;
	private JButton modifyButton = null;
	private JButton refreshButton = null;
	private JPanel buttonPanel = null;
	private OrgTypeTable ot = new OrgTypeTable();
	
	
	private void initBodyPanel() {
		this.bodyPanel = new JPanel(new BorderLayout());
		ot.createTable();
		this.bodyPanel.add(ot.scrollPane, BorderLayout.CENTER);
		
		this.buttonPanel = new JPanel(); 
		this.modifyButton = new JButton("修改 ");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("刷新");
		this.refreshButton.addActionListener(this);
		this.buttonPanel.add(this.modifyButton);
		this.buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(this.buttonPanel, BorderLayout.SOUTH);
	}
	
	private void initHelpPanel() {
		this.helpPanel = new JPanel();
		this.helpPanel.setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void execute(JPanel workPanel) {
		workPanel.setLayout(new BorderLayout());
		
		this.tabbedPane = new JTabbedPane();
		this.initBodyPanel();
		this.initHelpPanel();
		this.tabbedPane.add("修改机构类别", this.bodyPanel);
		this.tabbedPane.add("修改机构类别帮助", this.helpPanel);
		
		workPanel.add(this.tabbedPane, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.modifyButton) {
			int n = ot.table.getSelectedRowCount();
			if (n != 1) {
				JOptionPane.showMessageDialog(null, "请选择一条记录！");
			} else {
				String id = ot.table.getValueAt(ot.table.getSelectedRow(), 0).toString();
				ModidyDialog modidyDialog = new ModidyDialog(id, this);
			}
		} else if (e.getSource() == this.refreshButton) {
			ot.refresh();
		}
		
	}
	
	public class ModidyDialog extends JDialog implements ActionListener {
		private OrgType orgType = null;
		private OrgTypeModifyAction action = null;
		private JPanel bodyPanel = null;
		private JLabel orgTypeIdLabel = null;
		private JTextField orgTypeIdField = null;
		private JLabel orgTypeNameLabel = null;
		private JTextField orgTypeNameField = null;
		private JLabel orgTypeMemoLabel = null;
		private JTextArea orgTypeMemoArea = null;
		private JScrollPane scrollPane = null;
		private JPanel buttonPanel = null;
		private JButton modifyButton = null;
		private JButton restoreButton = null;
		
		private void init() {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int xAxis = (int) ((dimension.getWidth()- 600)/2);
			int yAxis= (int) ((dimension.getHeight()- 550)/2);
			this.setBounds(xAxis, yAxis, 600, 550);
			
			this.bodyPanel = (JPanel)this.getContentPane();
			this.bodyPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			this.orgTypeIdLabel = new JLabel("机构类别编号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgTypeIdLabel, gbc);
			
			this.orgTypeIdField = new JTextField(20);
			this.orgTypeIdField.setEditable(false);
			this.orgTypeIdField.setText(orgType.getOrgTypeId());
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgTypeIdField, gbc);
			
			this.orgTypeNameLabel = new JLabel("机构类别名称：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgTypeNameLabel, gbc);
			
			this.orgTypeNameField = new JTextField(20);
			this.orgTypeNameField.setText(orgType.getOrgTypeName());
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgTypeNameField, gbc);
			
			this.orgTypeMemoLabel = new JLabel("机构类别备注：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgTypeMemoLabel, gbc);
			
			this.orgTypeMemoArea = new JTextArea(8, 20);
			this.orgTypeMemoArea.setText(orgType.getOrgTypeMemo());
			this.scrollPane = new JScrollPane();
			this.scrollPane.getViewport().add(this.orgTypeMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.bodyPanel.add(this.scrollPane, gbc);
			
			this.buttonPanel = new JPanel(new FlowLayout());
			this.modifyButton = new JButton("刷新");
			this.modifyButton.addActionListener(this);
			this.restoreButton = new JButton("还原");
			this.restoreButton.addActionListener(this);
			this.buttonPanel.add(this.modifyButton);
			this.buttonPanel.add(this.restoreButton);
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.bodyPanel.add(this.buttonPanel, gbc);
			
			this.setTitle("修改");
			this.setVisible(true);
			
		}
		
		public ModidyDialog() {
			// TODO Auto-generated constructor stub
		}
		
		public ModidyDialog(String id, OrgTypeModifyAction action) {
			this.action = action;
			OrgTypeDAO orgTypeDAO = new OrgTypeDAOImpl();
			this.orgType = orgTypeDAO.findById(id);
			this.init();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.modifyButton) {
				String id = this.orgTypeIdField.getText();
				String name = this.orgTypeNameField.getText();
				String memo = this.orgTypeMemoArea.getText();
				OrgType o = new OrgType();
				o.setOrgTypeId(id);
				o.setOrgTypeName(name);
				o.setOrgTypeMemo(memo);
				OrgTypeDAO dao = new OrgTypeDAOImpl();
				if (dao.modifyOrgType(id, o)) {
					JOptionPane.showMessageDialog(this, "修改成功");
					ot.refresh();
				} else {
					JOptionPane.showMessageDialog(this, "修改失败");
				}
				
			} else if (e.getSource() == this.restoreButton) {
				this.orgTypeIdField.setText(this.orgType.getOrgTypeId());
				this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
				this.orgTypeMemoArea.setText(this.orgType.getOrgTypeMemo());
			}
			
		}
	}
}
