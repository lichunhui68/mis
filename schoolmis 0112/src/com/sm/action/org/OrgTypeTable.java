package com.sm.action.org;

import java.util.List;

import com.sm.framework.model.dao.impl.OrgTypeDAO;
import com.sm.framework.model.dao.impl.OrgTypeDAOImpl;
import com.sm.framework.model.entity.OrgType;

public class OrgTypeTable extends MyTableModel {
	public static String[] OrgTypeTitle = { "机构类别编号", "机构类别名称", "结构类别备注" };

	
	public OrgTypeTable() {
		super(OrgTypeTitle);
	}

	
	public String[][] getData() {
		OrgTypeDAO dao = new OrgTypeDAOImpl();
		List<OrgType> list = dao.findAll();
		String[][] data = new String[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			OrgType o = list.get(i);
			data[i][0] = o.getOrgTypeId();
			data[i][1] = o.getOrgTypeName();
			data[i][2] = o.getOrgTypeMemo();
		}
		return data;
	}
	
	public String[][] getData(List<OrgType> list) {
		String[][] data = new String[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			OrgType o = list.get(i);
			data[i][0] = o.getOrgTypeId();
			data[i][1] = o.getOrgTypeName();
			data[i][2] = o.getOrgTypeMemo();
		}
		return data;
	}
}
