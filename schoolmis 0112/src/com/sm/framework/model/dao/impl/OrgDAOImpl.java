package com.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.framework.model.dbmanager.DBManager;
import com.sm.framework.model.entity.Org;

public class OrgDAOImpl extends DBManager implements OrgDAO {

	@Override
	public boolean addOrg(Org org) {
		int count = updateDB("insert into org(orgId, orgNo, orgName, orgMemo, orgTypeId) "
				+ "values(?, ?, ?, ?, ?)", 
				new Object[]{ org.getOrgId(), org.getOrgNo(), org.getOrgName(), 
						org.getOrgMemo(), org.getOrgTypeId()});
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeOrg(String orgId) {
		int count = updateDB("delete from org where orgId = ?", 
				new Object[]{ orgId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyOrg(String orgId, Org org) {
		int count = updateDB("update org set orgNo = ?, orgName = ?, orgMemo = ?, orgTypeId = ? "
				+ "where orgId = ?", 
				new Object[]{ org.getOrgNo(), org.getOrgName(), org.getOrgMemo(), 
						org.getOrgTypeId(), orgId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Org findById(String orgId) {
		Org o = null;
		ResultSet rs = queryDB("select * from org where orgId = ?", 
				new Object[]{ orgId });
		try {
			if (rs.next()) {
				o = new Org();
				o.setOrgId(rs.getString("orgId"));
				o.setOrgNo(rs.getString("orgNo"));
				o.setOrgName(rs.getString("orgName"));
				o.setOrgMemo(rs.getString("orgMemo"));
				o.setOrgTypeId(rs.getString("orgTypeId"));
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
	public List<Org> findAll() {
		List<Org> list = new ArrayList<Org>();
		ResultSet rs = queryDB("select * from org");
		try {
			while (rs.next()) {
				Org o = new Org();
				o.setOrgId(rs.getString("orgId"));
				o.setOrgNo(rs.getString("orgNo"));
				o.setOrgName(rs.getString("orgName"));
				o.setOrgMemo(rs.getString("orgMemo"));
				o.setOrgTypeId(rs.getString("orgTypeId"));
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
	public List<Org> findByLike(Org org) {
		List<Org> list = new ArrayList<Org>();
		String oId = org.getOrgId();
		String oNo = org.getOrgNo();
		String oName = org.getOrgName();
		String oMemo = org.getOrgMemo();
		String otId = org.getOrgTypeId();
		String select = "select * from org where 1=1";
		String where = "";
		if (oId != null && oId.length() > 0) {
			where = where + "and orgId like '%" + oId + "%'";
		}
		if (oNo != null && oNo.length() > 0) {
			where = where + "and orgNo like '%" + oNo + "%'";
		}
		if (oName != null && oName.length() > 0) {
			where = where + "and orgName like '%" + oName + "%'";
		}
		if (oMemo != null && oMemo.length() > 0) {
			where = where + "and orgMemo like '%" + oMemo + "%'";
		}
		if (otId != null && otId.length() > 0) {
			where = where + "and orgTypeId like '%" + otId + "%'";
		}
		ResultSet rs = queryDB(select + where);
		System.out.println(select + where);
		try {
			while (rs.next()) {
				Org o = new Org();
				o.setOrgId(rs.getString("orgId"));
				o.setOrgNo(rs.getString("orgNo"));
				o.setOrgName(rs.getString("orgName"));
				o.setOrgMemo(rs.getString("orgMemo"));
				o.setOrgTypeId(rs.getString("orgTypeId"));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
