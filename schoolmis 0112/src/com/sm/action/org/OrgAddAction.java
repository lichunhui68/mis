package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class OrgAddAction implements FunctionAction {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JPanel buttonPanel = null;
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
	private JButton addButton = null;
	private JButton cleanButton = null;
	
	private void cleanAll() {
		this.orgIdField.setText("");
		this.orgNoField.setText("");
		this.orgNameField.setText("");
		this.orgMemoArea.setText("");
		this.orgTypeIdField.setText("");
	}
	
	
	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.EAST;
		this.orgIdLabel = new JLabel("机构编号：");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		this.bodyPanel.add(this.orgIdLabel, gbc);
		
		this.orgIdField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.orgIdField, gbc);
		
		this.orgNoLabel = new JLabel("机构排名：");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.orgNoLabel, gbc);
		
		this.orgNoField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.orgNoField, gbc);
		
		this.orgNameLabel = new JLabel("机构名称：");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.orgNameLabel, gbc);
		
		this.orgNameField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.orgNameField, gbc);
		
		this.orgMemoLabel = new JLabel("机构备注：");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.bodyPanel.add(this.orgMemoLabel, gbc);
		
		this.orgMemoArea = new JTextArea(8, 20);
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
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.bodyPanel.add(this.orgTypeIdField, gbc);
		
		this.buttonPanel = new JPanel(new FlowLayout());
		this.addButton = new JButton("增加");
		this.addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Org o = new Org();
				OrgDAO dao = new OrgDAOImpl();
				o.setOrgId(orgIdField.getText());
				o.setOrgNo(orgNoField.getText());
				o.setOrgName(orgNameField.getText());
				o.setOrgMemo(orgMemoArea.getText());
				o.setOrgTypeId(orgTypeIdField.getText());
				if (dao.addOrg(o)) {
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
		this.buttonPanel.add(this.addButton);
		this.buttonPanel.add(this.cleanButton);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		this.bodyPanel.add(this.buttonPanel, gbc);
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
		this.tabbedPane.add("增加机构", this.bodyPanel);
		this.tabbedPane.add("增加机构帮助", this.helpPanel);
		
		workPanel.add(this.tabbedPane, BorderLayout.CENTER);		
	}
}
