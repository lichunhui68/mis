package com.sm.a.test;

import java.util.List;

import com.sm.framework.model.dao.impl.OrgTypeDAO;
import com.sm.framework.model.dao.impl.OrgTypeDAOImpl;
import com.sm.framework.model.entity.OrgType;

public class OrgTypeDAOImplTest {
	public static void main(String[] args) {
		
		OrgTypeDAO orgTypeDAO = new OrgTypeDAOImpl();
		
		//add
//		OrgType o = new OrgType();
//		o.setOrgTypeId("254");
//		o.setOrgTypeName("667");
//		o.setOrgTypeMemo("668");
//		System.out.println(orgTypeDAO.addOrgType(o));
		
		//remove
//		System.out.println(orgTypeDAO.removeOrgType(""));
		
		//modify
//		OrgType o = new OrgType();
//		o.setOrgTypeName("555");
//		o.setOrgTypeMemo("333");
//		System.out.println(orgTypeDAO.modifyOrgType("111", o));
		
		//find
//		System.out.println(orgTypeDAO.findByIdOrgType("111"));
		
		//findAll
//		List<OrgType> list = orgTypeDAO.findAll();
//		for (OrgType o : list) {
//			System.out.println(o);
//		}
		
		//findLike
		OrgType orgType = new OrgType();
		orgType.setOrgTypeName("aa");
		List<OrgType> list = orgTypeDAO.findByLike(orgType);
		for (OrgType o : list) {
			System.out.println(o);
		}
	}
}
