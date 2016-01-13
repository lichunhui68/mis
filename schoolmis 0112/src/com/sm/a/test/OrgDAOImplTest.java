package com.sm.a.test;

import java.util.List;

import com.sm.framework.model.dao.impl.OrgDAO;
import com.sm.framework.model.dao.impl.OrgDAOImpl;
import com.sm.framework.model.entity.Org;

public class OrgDAOImplTest {
	public static void main(String[] args) {
		
		//OrgDAOImplTest
		OrgDAO orgDAO = new OrgDAOImpl();
		
		//add
//		Org o = new Org();
//		o.setOrgId("010");
//		o.setOrgNo("a010");
//		o.setOrgName("test");
//		o.setOrgMemo("test");
//		o.setOrgTypeId("000");
//		System.out.println(orgDAO.addOrg(o));
		
		//modify
//		Org o = new Org();
//		o.setOrgNo("a002");
//		o.setOrgName("modify");
//		o.setOrgMemo("modify");
//		o.setOrgTypeId("111");
//		System.out.println(orgDAO.modifyOrg("008", o));
		
		//remove
//		System.out.println(orgDAO.removeOrg("008"));
		
		//findById
//		System.out.println(orgDAO.findById("007"));
		
		//findAll
//		List<Org> list = orgDAO.findAll();
//		for (Org org : list) {
//			System.out.println(org);
//		}
		
		//findByLike
		Org o = new Org();
		o.setOrgNo("1");
		o.setOrgName("3");
		List<Org> list = orgDAO.findByLike(o);
		for (Org org : list) {
			System.out.println(org);
		}
		
	}
}
