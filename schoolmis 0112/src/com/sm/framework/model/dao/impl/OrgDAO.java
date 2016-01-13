package com.sm.framework.model.dao.impl;

import java.util.List;

import com.sm.framework.model.entity.Org;

public interface OrgDAO {
	public boolean addOrg(Org org);
	public boolean removeOrg(String orgId);
	public boolean modifyOrg(String orgId, Org org);
	
	public Org findById(String orgId);
	public List<Org> findAll();
	public List<Org> findByLike(Org org);
}
