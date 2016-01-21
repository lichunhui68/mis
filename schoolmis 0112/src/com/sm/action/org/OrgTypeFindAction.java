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

import com.sm.framework.model.dao.impl.OrgTypeDAO;
import com.sm.framework.model.dao.impl.OrgTypeDAOImpl;
import com.sm.framework.model.entity.OrgType;

public class OrgTypeFindAction implements FunctionAction, ActionListener {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JPanel topPanel = null;
	private JLabel nameLabel = null;
	private JTextField nameField = null;
	private JButton findButton = null;
	private JButton detailButton = null;
	private JPanel buttonPanel = null;
	private OrgTypeTable ot = new OrgTypeTable();

	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new BorderLayout());

		this.topPanel = new JPanel(new FlowLayout());
		this.nameLabel = new JLabel("机构类别名称：");
		this.nameField = new JTextField(12);
		this.findButton = new JButton("查询");
		this.findButton.addActionListener(this);
		this.topPanel.add(this.nameLabel);
		this.topPanel.add(this.nameField);
		this.topPanel.add(this.findButton);
		this.bodyPanel.add(this.topPanel, BorderLayout.NORTH);

		ot.createTable();
		this.bodyPanel.add(ot.scrollPane, BorderLayout.CENTER);

		this.buttonPanel = new JPanel(new FlowLayout());
		this.detailButton = new JButton("详情");
		this.detailButton.addActionListener(this);
		this.buttonPanel.add(this.detailButton);
		this.bodyPanel.add(this.buttonPanel, BorderLayout.SOUTH);
	}

	private void inHelpPanel() {
		this.helpPanel = new JPanel();
		this.helpPanel.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void execute(JPanel workPanel) {
		workPanel.setLayout(new BorderLayout());

		this.tabbedPane = new JTabbedPane();

		this.inBodyPanel();
		this.inHelpPanel();
		this.tabbedPane.add("查询机构类别", this.bodyPanel);
		this.tabbedPane.add("查询机构类别帮助", this.helpPanel);

		workPanel.add(this.tabbedPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.detailButton) {
			int n = ot.table.getSelectedRowCount();
			if (n != 1) {
				JOptionPane.showMessageDialog(null, "请选择一条记录查询！");
			} else {
				String id = ot.table.getValueAt(ot.table.getSelectedRow(),0).toString();
				FindDialog findDialog = new FindDialog(id);
			}
		} else if (e.getSource() == this.findButton) {
			String name = this.nameField.getText();
			OrgTypeDAO dao = new OrgTypeDAOImpl();
			OrgType topOrgType = new OrgType();
			topOrgType.setOrgTypeName(name);
			ot.tableModel.setDataVector(ot.getData(dao.findByLike(topOrgType)), ot.OrgTypeTitle);
		}
	}

	public class FindDialog extends JDialog {
		private OrgType orgType = null;
		private JPanel bodyPanel = null;
		private JLabel orgTypeIdLabel = null;
		private JTextField orgTypeIdField = null;
		private JLabel orgTypeNameLabel = null;
		private JTextField orgTypeNameField = null;
		private JLabel orgTypeMemoLabel = null;
		private JTextArea orgTypeMemoArea = null;
		private JScrollPane scrollPane = null;

		private void init() {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int xAxis = (int) ((dimension.getWidth() - 600) / 2);
			int yAxis = (int) ((dimension.getHeight() - 550) / 2);
			this.setBounds(xAxis, yAxis, 600, 550);

			this.bodyPanel = (JPanel) this.getContentPane();
			this.bodyPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();

			this.orgTypeIdLabel = new JLabel("机构类别编号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgTypeIdLabel, gbc);

			this.orgTypeIdField = new JTextField(20);
			this.orgTypeIdField.setText(this.orgType.getOrgTypeId());
			this.orgTypeIdField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgTypeIdField, gbc);

			this.orgTypeNameLabel = new JLabel("机构类别名称：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgTypeNameLabel, gbc);

			this.orgTypeNameField = new JTextField(20);
			this.orgTypeNameField.setText(this.orgType.getOrgTypeName());
			this.orgTypeNameField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgTypeNameField, gbc);

			this.orgTypeMemoLabel = new JLabel("机构类别备注：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgTypeMemoLabel, gbc);

			this.orgTypeMemoArea = new JTextArea(8, 20);
			this.orgTypeMemoArea.setText(this.orgType.getOrgTypeMemo());
			this.orgTypeMemoArea.setEditable(false);
			this.scrollPane = new JScrollPane();
			this.scrollPane.getViewport().add(this.orgTypeMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.bodyPanel.add(this.scrollPane, gbc);

			this.setTitle("详情");
			this.setVisible(true);
		}

		public FindDialog() {
			// TODO Auto-generated constructor stub
		}

		public FindDialog(String id) {
			OrgTypeDAO orgTypeDAO = new OrgTypeDAOImpl();
			this.orgType = orgTypeDAO.findById(id);
			this.init();
		}
	}
}
