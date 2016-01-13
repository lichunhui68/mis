package com.sm.framework.model.dao.impl;

import java.util.List;

import com.sm.framework.model.entity.Menu;

public interface MenuDAO {
	public boolean addMenu(Menu menu);
	public boolean removeMenu(String menuId);
	public boolean modifyMenu(String menuId, Menu menu);
	
	public Menu findById(String menuId);
	public List<Menu> findAll();
	public List<Menu> findBySql(String sql);

}
