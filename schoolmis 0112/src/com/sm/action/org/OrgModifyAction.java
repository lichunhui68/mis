package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class OrgModifyAction implements FunctionAction, ActionListener {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JPanel buttonPanel = null;
	private JButton modifyButton = null;
	private JButton refreshButton = null;
	private OrgTable ot = new OrgTable();
	
	
	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new BorderLayout());
		ot.createTable();
		this.bodyPanel.add(ot.scrollPane, BorderLayout.CENTER);
		
		this.buttonPanel = new JPanel(new FlowLayout());
		this.modifyButton = new JButton("修改");
		this.modifyButton.addActionListener(this);
		this.refreshButton = new JButton("刷新");
		this.refreshButton.addActionListener(this);
		this.buttonPanel.add(this.modifyButton);
		this.buttonPanel.add(this.refreshButton);
		this.bodyPanel.add(this.buttonPanel, BorderLayout.SOUTH);
	}
	
	private void inHelpPanel() {
		this.helpPanel = new JPanel();
		this.helpPanel.setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void execute(JPanel workPanel) {
		workPanel.removeAll();
		workPanel.repaint();
		workPanel.setLayout(new BorderLayout());
		
		this.tabbedPane = new JTabbedPane();
		this.inBodyPanel();
		this.inHelpPanel();
		this.tabbedPane.add("修改机构", this.bodyPanel);
		this.tabbedPane.add("修改机构帮助", this.helpPanel);
		
		workPanel.add(this.tabbedPane, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.modifyButton) {
			int n = ot.table.getSelectedRowCount();
			if (n != 1) {
				JOptionPane.showMessageDialog(null, "请选择一条修改！");
			} else {
				String id = ot.table.getValueAt(ot.table.getSelectedRow(), 0).toString();
				ModifyDialog modifyDialog = new ModifyDialog(id, this);
			}
		} else if (e.getSource() == this.refreshButton) {
			ot.refresh();
		}
	}
	
	public class ModifyDialog extends JDialog implements ActionListener {
		private Org org = null;
		private OrgModifyAction action = null;
		private JPanel bodyPanel = null;
		private JLabel orgIdLabel = null;
		private JTextField orgIdField = null;
		private JLabel orgNoLabel = null;
		private JTextField orgNoField = null;
		private JLabel orgNameLabel = null;
		private JTextField orgNameField = null;
		private JLabel orgMemoLabel = null;
		private JTextArea orgMemoArea = null;
		private JScrollPane scrollPane = null;
		private JLabel orgTypeIdLabel = null;
		private JTextField orgTypeIdField = null;
		private JPanel buttonPanel = null;
		private JButton modifyButton = null;
		private JButton resetButton = null;
		
		private void init() {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int xAxis = (int) ((dimension.getWidth()- 600)/2);
			int yAxis= (int) ((dimension.getHeight()- 550)/2);
			this.setBounds(xAxis, yAxis, 600, 550);
			
			this.bodyPanel = (JPanel)this.getContentPane();
			this.bodyPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints(); 
			
			this.orgIdLabel = new JLabel("部门编号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgIdLabel, gbc);
			
			this.orgIdField = new JTextField(this.org.getOrgId(), 20);
			this.orgIdField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgIdField, gbc);
			
			this.orgNoLabel = new JLabel("部门排名：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgNoLabel, gbc);
			
			this.orgNoField = new JTextField(this.org.getOrgNo(), 20);
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgNoField, gbc);
			
			this.orgNameLabel = new JLabel("部门名称：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgNameLabel, gbc);
			
			this.orgNameField = new JTextField(this.org.getOrgName(), 20);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgNameField, gbc);
			
			this.orgMemoLabel = new JLabel("部门备注：");
			gbc.gridx = 0;
			gbc.gridy = 3;
			this.bodyPanel.add(this.orgMemoLabel, gbc);
			
			this.orgMemoArea = new JTextArea(this.org.getOrgMemo(), 8, 20);
			this.scrollPane = new JScrollPane(this.orgMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.bodyPanel.add(this.scrollPane, gbc);
			
			this.orgTypeIdLabel = new JLabel("类别编号：");
			gbc.gridx = 0;
			gbc.gridy = 4;
			this.bodyPanel.add(this.orgTypeIdLabel, gbc);
			
			this.orgTypeIdField = new JTextField(this.org.getOrgTypeId(), 20);
			gbc.gridx = 1;
			gbc.gridy = 4;
			this.bodyPanel.add(this.orgTypeIdField, gbc);
			
			this.buttonPanel = new JPanel();
			this.modifyButton = new JButton("刷新");
			this.modifyButton.addActionListener(this);
			this.resetButton = new JButton("还原");
			this.resetButton.addActionListener(this);
			this.buttonPanel.add(this.modifyButton);
			this.buttonPanel.add(this.resetButton);
			gbc.gridx = 1;
			gbc.gridy = 5;
			this.bodyPanel.add(this.buttonPanel, gbc);
			
			this.setTitle("modify");
			this.setVisible(true);
		}
		
		public ModifyDialog() {
			// TODO Auto-generated constructor stub
		}
		
		public ModifyDialog(String id, OrgModifyAction action) {
			this.action = action;
			OrgDAO dao = new OrgDAOImpl();
			this.org = dao.findById(id);
			this.init();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.modifyButton) {
				String id = this.orgIdField.getText();
				String no = this.orgNoField.getText();
				String name = this.orgNameField.getText();
				String memo = this.orgMemoArea.getText();
				String otid = this.orgTypeIdField.getText();
				Org o = new Org();
				o.setOrgId(id);
				o.setOrgNo(no);
				o.setOrgName(name);
				o.setOrgMemo(memo);
				o.setOrgTypeId(otid);
				OrgDAO dao = new OrgDAOImpl();
				if (dao.modifyOrg(id, o)) {
					JOptionPane.showMessageDialog(null, "修改成功");
					ot.refresh();
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			} else if (e.getSource() == this.resetButton) {
				this.orgNoField.setText(this.org.getOrgNo());
				this.orgNameField.setText(this.org.getOrgId());
				this.orgMemoArea.setText(this.org.getOrgMemo());
				this.orgTypeIdField.setText(this.org.getOrgTypeId());
			}
			
		}
	}
}
