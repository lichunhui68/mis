package com.sm.framework.model.dao.impl;

import java.util.List;

import com.sm.framework.model.entity.MisUser;

public interface MisUserDAO {
	public boolean addMisUser(MisUser misUser);
	public boolean removeMisUser(String userId);
	public boolean modifyMisUser(String userId, MisUser misUser);
	
	public MisUser findById(String userId);
	public List<MisUser> findAll();
}
