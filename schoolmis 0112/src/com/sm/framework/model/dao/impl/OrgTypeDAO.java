package com.sm.framework.model.dao.impl;

import java.util.List;

import com.sm.framework.model.entity.OrgType;

public interface OrgTypeDAO {
	public boolean addOrgType(OrgType orgType);
	public boolean removeOrgType(String orgTypeId);
	public boolean modifyOrgType(String orgTypeId, OrgType orgType);
	
	public OrgType findByName(String orgTypeName);
	public OrgType findById(String orgTypeId);
	public List<OrgType> findAll();
	public List<OrgType> findByLike(OrgType orgType);
}