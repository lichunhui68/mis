package com.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.framework.model.dbmanager.DBManager;
import com.sm.framework.model.entity.MisFunction;

public class MisFunctionDAOImpl extends DBManager implements MisFunctionDAO {

	@Override
	public boolean addMisFunction(MisFunction misFunction) {
		int count = updateDB(
				"insert into misFunction(functionId, functionName, functionClass,"
						+ "functionMemo, menuId) values(?, ?, ?, ?, ?)",
				new Object[] { misFunction.getFunctionId(),
						misFunction.getFunctionName(),
						misFunction.getFunctionClass(),
						misFunction.getFunctionMemo(), misFunction.getMenuId() });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeMisFunction(String functionId) {
		int count = updateDB("delete from misFunction where functionId = ?",
				new Object[] { functionId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyMisFunction(String functionId, MisFunction misFunction) {
		int count = updateDB("update misFunction set functionName = ?, functionClass = ?, "
				+ "functionMemo = ?, menuId = ? where functionId = ?", 
				new Object[]{ misFunction.getFunctionName(), misFunction.getFunctionClass(), 
						misFunction.getFunctionMemo(), misFunction.getMenuId(), functionId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public MisFunction findById(String functionId) {
		MisFunction m = null;
		ResultSet rs = queryDB("select * from misFunction where functionId = ?", 
				new Object[]{ functionId });
		try {
			if (rs.next()) {
				m = new MisFunction();
				m.setFunctionId(rs.getString("functionId"));
				m.setFunctionName(rs.getString("functionName"));
				m.setFunctionClass(rs.getString("functionClass"));
				m.setFunctionMemo(rs.getString("functionMemo"));
				m.setMenuId(rs.getString("MenuId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return m;
	}

	@Override
	public List<MisFunction> findAll() {
		List<MisFunction> list = new ArrayList<MisFunction>();
		ResultSet rs = queryDB("select * from misFunction");
		try {
			while (rs.next()) {
				MisFunction m = new MisFunction();
				m.setFunctionId(rs.getString("functionId"));
				m.setFunctionName(rs.getString("functionName"));
				m.setFunctionClass(rs.getString("functionClass"));
				m.setFunctionMemo(rs.getString("functionMemo"));
				m.setMenuId(rs.getString("MenuId"));
				list.add(m);
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
	public List<MisFunction> findByMenuId(String menuId) {
		List<MisFunction> list = new ArrayList<MisFunction>();
		ResultSet rs = queryDB("select * from misFunction where menuId = ?", 
				new Object[]{ menuId });
		try {
			while (rs.next()) {
				MisFunction m = new MisFunction();
				m.setFunctionId(rs.getString("functionId"));
				m.setFunctionName(rs.getString("functionName"));
				m.setFunctionClass(rs.getString("functionClass"));
				m.setFunctionMemo(rs.getString("functionMemo"));
				m.setMenuId(rs.getString("MenuId"));
				list.add(m);
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
	public List<MisFunction> findByMenuIdAndRoleId(String menuId, String roleId) {
		List<MisFunction> list = new ArrayList<MisFunction>();
		ResultSet rs = queryDB("select * from misFunction where menuId = ? and functionId in (select functionId from auth where roleId = ?)", 
				new Object[]{ menuId, roleId});
		try {
			while (rs.next()) {
				MisFunction m = new MisFunction();
				m.setFunctionId(rs.getString("functionId"));
				m.setFunctionName(rs.getString("functionName"));
				m.setFunctionClass(rs.getString("functionClass"));
				m.setFunctionMemo(rs.getString("functionMemo"));
				m.setMenuId(rs.getString("MenuId"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}

}
