package com.sm.action.org;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class MyTableModel {
	public JTable table = null;
	public DefaultTableModel tableModel = null;
	public JScrollPane scrollPane = null;
	public String[] title = null;
	
	
	public MyTableModel(String[] title) {
		this.title = title;
	}
	
	public void refresh() {
		this.tableModel.setDataVector(this.getData(), this.title);
	}
	
	public String[][] getData() {
		String[][] data = null;
		return data;
	}
	
	public void createTable() {
		this.tableModel = new DefaultTableModel(this.getData(), this.title);
		this.table = new JTable(this.tableModel){
			// 让表格无法编辑
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.scrollPane = new JScrollPane(this.table);
	}
}
