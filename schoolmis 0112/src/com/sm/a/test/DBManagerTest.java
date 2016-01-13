package com.sm.a.test;

import com.sm.framework.model.dbmanager.DBManager;

public class DBManagerTest {
	public static void main(String[] args) {
		DBManager dm = new DBManager();
		dm.getConnection();
	}
}
