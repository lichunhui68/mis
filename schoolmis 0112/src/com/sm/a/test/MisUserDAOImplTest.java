package com.sm.a.test;

import java.util.List;

import com.sm.framework.model.dao.impl.MisUserDAO;
import com.sm.framework.model.dao.impl.MisUserDAOImpl;
import com.sm.framework.model.entity.MisUser;

public class MisUserDAOImplTest {
	public static void main(String[] args) {
			
//		MisUserDAOImplTest
		MisUserDAO misUserDAO = new MisUserDAOImpl();
		
//		add
//		MisUser m = new MisUser();
//		m.setUserId("888");
//		m.setUserName("test");
//		m.setUserPwd("666");
//		m.setUserMemo("test");
//		m.setRoleId("test");
//		m.setAddressId("test");
//		System.out.println(misUserDAO.addMisUser(m));
		
//		remove
//		System.out.println(misUserDAO.removeMisUser("888"));
		
//		modify
//		MisUser m = new MisUser();
//		m.setUserName("888");
//		m.setUserPwd("888");
//		m.setUserMemo("888");
//		m.setRoleId("888");
//		m.setAddressId("888");
//		System.out.println(misUserDAO.modifyMisUser("test", m));
		
//		findById
//		System.out.println(misUserDAO.findById("test"));
		
//		findAll
		List<MisUser> list = misUserDAO.findAll();
		for (MisUser misUser : list) {
			System.out.println(misUser);
		}
	}
}
