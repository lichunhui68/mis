package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class OrgRemoveAction implements FunctionAction, ActionListener {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JPanel buttonPanel = null;
	private JButton removeButton = null;
	private JButton refreshButton = null;
	private OrgTable ot = new OrgTable();
	
	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new BorderLayout());
		ot.createTable();
		this.bodyPanel.add(ot.scrollPane, BorderLayout.CENTER);
		
		this.buttonPanel = new JPanel();
		this.removeButton = new JButton("删除");
		this.removeButton.addActionListener(this);
		this.refreshButton = new JButton("刷新");
		this.refreshButton.addActionListener(this);
		this.buttonPanel.add(this.removeButton);
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
		this.tabbedPane.add("删除机构", this.bodyPanel);
		this.tabbedPane.add("删除机构帮助", this.helpPanel);
		
		workPanel.add(this.tabbedPane, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.removeButton) {
			int n = ot.table.getSelectedRowCount();
			if (n != 1) {
				JOptionPane.showMessageDialog(null, "请选择一条记录！");
			} else {
				String id = ot.table.getValueAt(ot.table.getSelectedRow(), 0).toString();
				OrgDAO dao = new OrgDAOImpl();
				int result = JOptionPane.showConfirmDialog(null, "您确定要删除吗？");
				if (result == JOptionPane.YES_OPTION) {
					dao.removeOrg(id);
					ot.refresh();
				}
			}
		} else if (e.getSource() == this.refreshButton) {
			ot.refresh();
		}
	}
}
