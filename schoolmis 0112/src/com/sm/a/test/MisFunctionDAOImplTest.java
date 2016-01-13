package com.sm.a.test;

import java.util.List;

import com.sm.framework.model.dao.impl.MisFunctionDAO;
import com.sm.framework.model.dao.impl.MisFunctionDAOImpl;
import com.sm.framework.model.entity.MisFunction;

public class MisFunctionDAOImplTest {
	public static void main(String[] args) {
		
		//MisFuntionDAOImplTest
		MisFunctionDAO dao = new MisFunctionDAOImpl();
		
		//add
//		MisFunction m = new MisFunction();
//		m.setFunctionId("8888");
//		m.setFunctionName("test");
//		m.setFunctionMemo("test");
//		m.setFunctionClass("test");
//		m.setMenuId("8888");
//		System.out.println(dao.addMisFunction(m));
		
		//modify
//		MisFunction m = new MisFunction();
//		m.setFunctionName("8888");
//		m.setFunctionClass("8888");
//		m.setFunctionMemo("8888");
//		m.setMenuId("8888");
//		System.out.println(dao.modifyMisFunction("8888", m));
		
		//remove
//		System.out.println(dao.removeMisFunction("8888"));
		
		//findById
//		System.out.println(dao.findById("1055"));
		
		//findByMenuId
//		List<MisFunction> list = dao.findByMenuId("1010");
//		for (MisFunction misFunction : list) {
//			System.out.println(misFunction);
//		}
		
		//findBymenuIdAndRoleId
//		List<MisFunction> list = dao.findByMenuIdAndRoleId("1010", "guest");
//		for (MisFunction misFunction : list) {
//			System.out.println(misFunction);
//		}
		
		//findAll
		List<MisFunction> list = dao.findAll();
		for (MisFunction misFunction : list) {
			System.out.println(misFunction);
		}
	}
}
