package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sm.action.org.OrgTypeFindAction.FindDialog;
import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class OrgFindAction implements FunctionAction, ActionListener {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JPanel topPanel = null;
	private JLabel nameLabel = null;
	private JTextField nameField = null;
	private JButton findButton = null;
	private JPanel buttonPanel = null;
	private JButton detailsButton = null;
	private OrgTable ot = new OrgTable();

	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new BorderLayout());

		this.topPanel = new JPanel();
		this.nameLabel = new JLabel("机构名称：");
		this.topPanel.add(this.nameLabel);
		this.nameField = new JTextField(12);
		this.topPanel.add(this.nameField);
		this.findButton = new JButton("查询");
		this.findButton.addActionListener(this);
		this.topPanel.add(this.findButton);
		this.bodyPanel.add(this.topPanel, BorderLayout.NORTH);

		ot.createTable();
		this.bodyPanel.add(ot.scrollPane, BorderLayout.CENTER);

		this.buttonPanel = new JPanel();
		this.detailsButton = new JButton("详情");
		this.detailsButton.addActionListener(this);
		this.buttonPanel.add(this.detailsButton);
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
		this.tabbedPane.add("查询机构", this.bodyPanel);
		this.tabbedPane.add("查询机构帮助", this.helpPanel);
		workPanel.add(this.tabbedPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.findButton) {
			String name = this.nameField.getText();
			OrgDAO dao = new OrgDAOImpl();
			Org topOrg = new Org();
			topOrg.setOrgName(name);
			ot.tableModel.setDataVector(ot.getData(dao.findByLike(topOrg)),
					ot.OrgTitle);
		} else if (e.getSource() == this.detailsButton) {
			int n = ot.table.getSelectedRowCount();
			if (n != 1) {
				JOptionPane.showMessageDialog(null, "请选择一条记录查询！");
			} else {
				String id = ot.table.getValueAt(ot.table.getSelectedRow(),0).toString();
				FindDialog findDialog = new FindDialog(id);
			}
		}
	}

	public class FindDialog extends JDialog {
		private Org org = null;
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
		
		public FindDialog() {
			// TODO Auto-generated constructor stub
		}
		
		public FindDialog(String id) {
			OrgDAO orgDAO = new OrgDAOImpl();
			this.org = orgDAO.findById(id);
			this.init();
		}

		private void init() {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int xAxis = (int) ((dimension.getWidth() - 600) / 2);
			int yAxis = (int) ((dimension.getHeight() - 550) / 2);
			this.setBounds(xAxis, yAxis, 600, 550);

			this.bodyPanel = (JPanel) this.getContentPane();
			this.bodyPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();

			gbc.anchor = GridBagConstraints.EAST;
			this.orgIdLabel = new JLabel("机构编号：");
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.fill = GridBagConstraints.BOTH;
			this.bodyPanel.add(this.orgIdLabel, gbc);

			this.orgIdField = new JTextField(20);
			this.orgIdField.setText(this.org.getOrgId());
			this.orgIdField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 0;
			this.bodyPanel.add(this.orgIdField, gbc);

			this.orgNoLabel = new JLabel("机构排名：");
			gbc.gridx = 0;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgNoLabel, gbc);

			this.orgNoField = new JTextField(20);
			this.orgNoField.setText(this.org.getOrgNo());
			this.orgNoField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 1;
			this.bodyPanel.add(this.orgNoField, gbc);

			this.orgNameLabel = new JLabel("机构名称：");
			gbc.gridx = 0;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgNameLabel, gbc);

			this.orgNameField = new JTextField(20);
			this.orgNameField.setText(this.org.getOrgName());
			this.orgNameField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.bodyPanel.add(this.orgNameField, gbc);

			this.orgMemoLabel = new JLabel("机构备注：");
			gbc.gridx = 0;
			gbc.gridy = 3;
			this.bodyPanel.add(this.orgMemoLabel, gbc);

			this.orgMemoArea = new JTextArea(8, 20);
			this.orgMemoArea.setText(this.org.getOrgMemo());
			this.orgMemoArea.setEditable(false);
			this.scrollPane = new JScrollPane();
			this.scrollPane.getViewport().add(this.orgMemoArea);
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.bodyPanel.add(this.scrollPane, gbc);

			this.orgTypeIdLabel = new JLabel("类别编号：");
			gbc.gridx = 0;
			gbc.gridy = 4;
			this.bodyPanel.add(this.orgTypeIdLabel, gbc);

			this.orgTypeIdField = new JTextField(20);
			this.orgTypeIdField.setText(this.org.getOrgTypeId());
			this.orgTypeIdField.setEditable(false);
			gbc.gridx = 1;
			gbc.gridy = 4;
			this.bodyPanel.add(this.orgTypeIdField, gbc);
			
			this.setTitle("详情");
			this.setVisible(true);
		}
		
		
	}
}