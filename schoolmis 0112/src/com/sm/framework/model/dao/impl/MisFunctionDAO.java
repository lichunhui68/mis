package com.sm.framework.model.dao.impl;

import java.util.List;

import com.sm.framework.model.entity.MisFunction;

public interface MisFunctionDAO {
	public boolean addMisFunction(MisFunction misFunction);
	public boolean removeMisFunction(String functionId);
	public boolean modifyMisFunction(String functionId, MisFunction misFunction);
	
	public MisFunction findById(String functionId);
	public List<MisFunction> findAll();
	
	public List<MisFunction> findByMenuId(String menuId);
	public List<MisFunction> findByMenuIdAndRoleId(String menuId, String roleId);
}
