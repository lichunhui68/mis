package com.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.framework.model.dbmanager.DBManager;
import com.sm.framework.model.entity.MisUser;

public class MisUserDAOImpl extends DBManager implements MisUserDAO {

	@Override
	public boolean addMisUser(MisUser misUser) {
		int count = updateDB(
				"insert into misUser(userId, userName, userPwd, userMemo, roleId, addressId) "
						+ "values(?, ?, ?, ?, ?, ?)",
				new Object[] { misUser.getUserId(), misUser.getUserName(),
						misUser.getUserPwd(), misUser.getUserMemo(),
						misUser.getRoleId(), misUser.getAddressId() });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeMisUser(String userId) {
		int count = updateDB("delete from misUser where userId = ?",
				new Object[] { userId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyMisUser(String userId, MisUser misUser) {
		int count = updateDB(
				"update misUser set userName = ?, userPwd = ?, "
						+ "userMemo = ?, roleId = ?, addressId = ? where userId = ?",
				new Object[] { misUser.getUserName(), misUser.getUserPwd(),
						misUser.getUserMemo(), misUser.getRoleId(),
						misUser.getAddressId(), userId });
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public MisUser findById(String userId) {
		MisUser m = null;
		ResultSet rs = queryDB("select * from misUser where userId = ?",
				new Object[] { userId });
		try {
			if (rs.next()) {
				m = new MisUser();
				m.setUserId(rs.getString("userId"));
				m.setUserName(rs.getString("userName"));
				m.setUserPwd(rs.getString("userPwd"));
				m.setUserMemo(rs.getString("userMemo"));
				m.setRoleId(rs.getString("roleId"));
				m.setAddressId(rs.getString("addressId"));
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
	public List<MisUser> findAll() {
		List<MisUser> list = new ArrayList<MisUser>();
		ResultSet rs = queryDB("select * from misUser");
		try {
			while (rs.next()) {
				MisUser m = new MisUser();
				m.setUserId(rs.getString("userId"));
				m.setUserName(rs.getString("userName"));
				m.setUserPwd(rs.getString("userPwd"));
				m.setUserMemo(rs.getString("userMemo"));
				m.setRoleId(rs.getString("roleId"));
				m.setAddressId(rs.getString("addressId"));
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