package com.sm.a.test;

import java.util.List;

import com.sm.framework.model.dao.impl.MenuDAO;
import com.sm.framework.model.dao.impl.MenuDAOImpl;
import com.sm.framework.model.entity.Menu;



public class MenuDAOImplTest {
	public static void main(String[] args) {
		
		//MenuDAOImpl
		MenuDAO menuDAO = new MenuDAOImpl();
		
		//add
//		Menu m = new Menu();
//		m.setMenuId("9009");
//		m.setMenuName("test");
//		m.setMenuMemo("test");
//		m.setWelcomePage("test");
//		System.out.println(menuDAO.addMenu(m));
	
		//modify
//		Menu m = new Menu();
//		m.setMenuName("9009");
//		m.setMenuMemo("9009");
//		m.setWelcomePage("9009");
//		System.out.println(menuDAO.modifyMenu("9009", m));
		
		//remove
//		System.out.println(menuDAO.removeMenu("9009"));
		
		//findById
//		System.out.println(menuDAO.findById("8020"));
		
		//findAll
//		List<Menu> list = menuDAO.findAll();
//		for (Menu menu : list) {
//			System.out.println(menu);
//		}
		
		//findBySql
		String sql = "select * from menu where menuId like '__'";
		List<Menu> list = menuDAO.findBySql(sql);
		for (Menu menu : list) {
			System.out.println(menu);
		}
	}
}
