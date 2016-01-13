package com.sm.action.org;

import java.util.List;

import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class OrgTable extends MyTableModel {
	public static String[] OrgTitle = {"机构编号", "机构排名", "机构名称", "机构备注", "机构类别编号"};
	
	public OrgTable() {
		super(OrgTitle);
	}
	
	public String[][] getData() {
		OrgDAO dao = new OrgDAOImpl();
		List<Org> list = dao.findAll();
		String[][] data = new String[list.size()][5];
 		for (int i = 0; i < list.size(); i++) {
			Org o = list.get(i);
			data[i][0] = o.getOrgId();
			data[i][1] = o.getOrgNo();
			data[i][2] = o.getOrgName();
			data[i][3] = o.getOrgMemo();
			data[i][4] = o.getOrgTypeId();
		}
		return data;
	}
	
	public String[][] getData(List<Org> list) {
		String[][] data = new String[list.size()][5];
 		for (int i = 0; i < list.size(); i++) {
			Org o = list.get(i);
			data[i][0] = o.getOrgId();
			data[i][1] = o.getOrgNo();
			data[i][2] = o.getOrgName();
			data[i][3] = o.getOrgMemo();
			data[i][4] = o.getOrgTypeId();
		}
		return data;
	}
}
