package com.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.framework.model.dbmanager.DBManager;
import com.sm.framework.model.entity.OrgType;


public class OrgTypeDAOImpl extends DBManager implements OrgTypeDAO {

	@Override
	public boolean addOrgType(OrgType orgType) {
		int count = updateDB(
				"insert into orgType(orgTypeId, orgTypeName, orgTypeMemo) "
						+ "values(?, ?, ?)",
				new Object[] { orgType.getOrgTypeId(),
						orgType.getOrgTypeName(), orgType.getOrgTypeMemo() });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeOrgType(String orgTypeId) {
		int count = updateDB("delete from orgType where orgTypeId = ?",
				new Object[] { orgTypeId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyOrgType(String orgTypeId, OrgType orgType) {
		int count = updateDB(
				"update orgType set orgTypeName = ?, "
						+ "orgTypeMemo = ? where orgTypeId = ?",
				new Object[] { orgType.getOrgTypeName(),
						orgType.getOrgTypeMemo(), orgTypeId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public OrgType findById(String orgTypeId) {
		OrgType o = null;
		ResultSet rs = queryDB("select * from orgType where orgTypeId = ?",
				new Object[] { orgTypeId });
		try {
			if (rs.next()) {
				o = new OrgType();
				o.setOrgTypeId(rs.getString("orgTypeId"));
				o.setOrgTypeName(rs.getString("orgTypeName"));
				o.setOrgTypeMemo(rs.getString("orgTypeMemo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return o;
	}

	@Override
	public List<OrgType> findAll() {
		List<OrgType> list = new ArrayList<OrgType>();
		ResultSet rs = queryDB("select * from orgType");
		try {
			while (rs.next()) {
				OrgType o = new OrgType();
				o.setOrgTypeId(rs.getString("orgTypeId"));
				o.setOrgTypeName(rs.getString("orgTypeName"));
				o.setOrgTypeMemo(rs.getString("orgTypeMemo"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public List<OrgType> findByLike(OrgType orgType) {
		List<OrgType> list = new ArrayList<OrgType>();
		String oId = orgType.getOrgTypeId();
		String oName = orgType.getOrgTypeName();
		String oMemo = orgType.getOrgTypeMemo();
		String select = "select * from orgType where 1=1";
		String where = "";
		if (oId != null && oId.length() > 0) {
			where = where + "and orgTypeId like '%" + oId + "%'";
		}
		if (oName != null && oName.length() > 0) {
			where = where + "and orgTypeName like '%" + oName + "%'";
		}
		if (oMemo != null && oMemo.length() > 0) {
			where = where + "and orgTypeMemo like '%" + oMemo + "%'";
		}
		ResultSet rs = queryDB(select + where);
		try {
			while (rs.next()) {
				OrgType o = new OrgType();
				o.setOrgTypeId(rs.getString("orgTypeId"));
				o.setOrgTypeName(rs.getString("orgTypeName"));
				o.setOrgTypeMemo(rs.getString("orgTypeMemo"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

	public OrgType findByName(String orgTypeName) {
		OrgType o = null;
		ResultSet rs = queryDB("select * from orgType where orgTypeName = ?",
				new Object[] { orgTypeName });
		try {
			if (rs.next()) {
				o = new OrgType();
				o.setOrgTypeId(rs.getString("orgTypeId"));
				o.setOrgTypeName(rs.getString("orgTypeName"));
				o.setOrgTypeMemo(rs.getString("orgTypeMemo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return o;
	}

}
