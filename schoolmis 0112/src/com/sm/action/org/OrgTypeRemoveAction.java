package com.sm.action.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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

import com.sm.framework.model.dao.impl.OrgTypeDAO;
import com.sm.framework.model.dao.impl.OrgTypeDAOImpl;
import com.sm.framework.model.entity.OrgType;

public class OrgTypeRemoveAction implements FunctionAction, ActionListener {
	private JTabbedPane tabbedPane = null;
	private JPanel bodyPanel = null;
	private JPanel helpPanel = null;
	private JPanel buttonPanel = null;
	private JButton removeButton = null;
	private JButton refreshButton = null;
	private OrgTypeTable ot = new OrgTypeTable();
	
	private void inBodyPanel() {
		this.bodyPanel = new JPanel(new BorderLayout());
		
		ot.createTable();
		this.bodyPanel.add(ot.scrollPane, BorderLayout.CENTER);
		
		this.buttonPanel = new JPanel(new FlowLayout());
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
		workPanel.setLayout(new BorderLayout());
		
		this.tabbedPane = new JTabbedPane();
		this.inBodyPanel();
		this.inHelpPanel();
		this.tabbedPane.add("删除机构类别", this.bodyPanel);
		this.tabbedPane.add("删除类别帮助", this.helpPanel);
		
		workPanel.add(this.tabbedPane, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.removeButton) {
			int n = ot.table.getSelectedRowCount();
			if (n != 1) {
				JOptionPane.showMessageDialog(null, "请选择一条记录删除！");
			}  else {
				String id = ot.table.getValueAt(ot.table.getSelectedRow(), 0).toString();
				OrgTypeDAO dao = new OrgTypeDAOImpl();
					int result = JOptionPane.showConfirmDialog(null, "您确定要删除吗");
					if (result == JOptionPane.YES_OPTION) {
						dao.removeOrgType(id);
						ot.refresh();
					} 
			}
		} else if (e.getSource() == this.refreshButton) {
			ot.refresh();
		}
		
	}

}
