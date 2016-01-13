package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import com.sm.framework.model.dao.impl.OrgTypeDAO;
import com.sm.framework.model.dao.impl.OrgTypeDAOImpl;
import com.sm.framework.model.entity.OrgType;

public class OrgTypeAddAction implements FunctionAction {
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JTabbedPane tabbedPane = null;
	private JLabel orgTypeIdLabel = null;
	private JTextField orgTypeIdField = null;
	private JLabel orgTypeNameLabel = null;
	private JTextField orgTypeNameField = null;
	private JLabel orgTypeMemoLabel = null;
	private JTextArea orgTypeMemoArea = null;
	private JScrollPane scrollPane = null;
	private JPanel buttonPanel = null;
	private JButton addButton = null;
	private JButton cleanButton = null;
	
	private void cleanAll() {
		this.orgTypeIdField.setText("");
		this.orgTypeNameField.setText("");
		this.orgTypeMemoArea.setText("");
	}

	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		this.orgTypeIdLabel = new JLabel("机构类别编号：");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		this.bodyPanel.add(this.orgTypeIdLabel, gbc);

		this.orgTypeIdField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		bodyPanel.add(this.orgTypeIdField, gbc);

		this.orgTypeNameLabel = new JLabel("机构类别名称：");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.bodyPanel.add(this.orgTypeNameLabel, gbc);

		this.orgTypeNameField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.orgTypeNameField, gbc);

		this.orgTypeMemoLabel = new JLabel("机构类别备注：");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.orgTypeMemoLabel, gbc);

		this.orgTypeMemoArea = new JTextArea(8, 20);
		this.scrollPane = new JScrollPane(this.orgTypeMemoArea);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.scrollPane, gbc);

		this.buttonPanel = new JPanel(new FlowLayout());
		this.addButton = new JButton("增加");
		this.addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = orgTypeIdField.getText();
				String name = orgTypeNameField.getText();
				String memo = orgTypeMemoArea.getText();
				OrgTypeDAO dao = new OrgTypeDAOImpl();
				OrgType o = new OrgType();
				o.setOrgTypeId(id);
				o.setOrgTypeName(name);
				o.setOrgTypeMemo(memo);
				if (dao.addOrgType(o)) {
					JOptionPane.showMessageDialog(null, "添加成功");
					cleanAll();
				}
			}
		});
		this.cleanButton = new JButton("重置");
		this.cleanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cleanAll();
			}
		});
		this.buttonPanel.add(addButton);
		this.buttonPanel.add(cleanButton);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		this.bodyPanel.add(this.buttonPanel, gbc);

	}

	private void initHelpPanel() {
		this.helpPanel = new JPanel();
		this.helpPanel.setBackground(Color.LIGHT_GRAY);

	}

	@Override
	public void execute(JPanel workPanel) {
		workPanel.setLayout(new BorderLayout());

		this.tabbedPane = new JTabbedPane();
		this.inBodyPanel();
		this.initHelpPanel();
		this.tabbedPane.add("增加用户类别", this.bodyPanel);
		this.tabbedPane.add("增加用户类别帮助", this.helpPanel);

		workPanel.add(tabbedPane, BorderLayout.CENTER);
	}
}