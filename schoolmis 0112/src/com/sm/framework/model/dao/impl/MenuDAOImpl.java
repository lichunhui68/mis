package com.sm.framework.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm.framework.model.dbmanager.DBManager;
import com.sm.framework.model.entity.Menu;

public class MenuDAOImpl extends DBManager implements MenuDAO {

	@Override
	public boolean addMenu(Menu menu) {
		int count = updateDB("insert into menu(menuId, menuName, menuMemo, welcomePage) "
				+ "values(?, ?, ?, ?)", 
				new Object[]{menu.getMenuId(), menu.getMenuName(), menu.getMenuMemo(),
						menu.getWelcomePage()});
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeMenu(String menuId) {
		int count = updateDB("delete from menu where menuId = ?", 
				new Object[]{menuId});
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyMenu(String menuId, Menu menu) {
		int count = updateDB("update menu set menuName = ?, menuMemo = ?, welcomePage = ? "
				+ "where menuId = ?",  
				new Object[]{menu.getMenuName(), menu.getMenuMemo(), menu.getWelcomePage(), menuId});
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Menu findById(String menuId) {
		Menu m = null;
		ResultSet rs = queryDB("select * from menu where menuId = ?",
				new Object[]{menuId});
		try {
			if (rs.next()) {
				m =  new Menu();
				m.setMenuId(rs.getString("menuId"));
				m.setMenuName(rs.getString("menuName"));
				m.setMenuMemo(rs.getString("menuMemo"));
				m.setWelcomePage(rs.getString("welcomePage"));
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
	public List<Menu> findAll() {
		List<Menu> list = new ArrayList<Menu>();
		ResultSet rs = queryDB("select * from menu");
		try {
			while (rs.next()) {
				Menu m = new Menu();
				m.setMenuId(rs.getString("menuId"));
				m.setMenuName(rs.getString("menuName"));
				m.setMenuMemo(rs.getString("menuMemo"));
				m.setWelcomePage(rs.getString("welcomePage"));
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
	public List<Menu> findBySql(String sql) {
		List<Menu> list = new ArrayList<Menu>();
		ResultSet rs = queryDB(sql);
		try {
			while (rs.next()) {
				Menu m = new Menu();
				m.setMenuId(rs.getString("menuId"));
				m.setMenuName(rs.getString("menuName"));
				m.setMenuMemo(rs.getString("menuMemo"));
				m.setWelcomePage(rs.getString("welcomePage"));
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
