package com.sm.framework.model.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connnectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connnectionUrl, db_name, db_password);
//			System.out.println("数据库连接成功");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length >0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private ResultSet rs = null;
//	private PreparedStatement psta = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("数据库连接成功");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connetionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("数据库连接成功");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connetionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connetionUrl, db_name, db_password);
//			System.out.println("数据库连接成功");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connetionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connetionUrl, db_name, db_password);
//			System.out.println("数据库连接成功");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;	
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null & obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connetionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connetionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name,
//					db_password);
//			System.out.println("DB connecion success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public int updateDB(String sql, Object... obj) {
//		int count = 1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i + 1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//
//	public ResultSet queryDB(String sql, Object... obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i + 1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name,
//					db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public int updateDB(String sql, Object... obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i + 1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
////			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connction success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;	
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name  = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

//public class DBManager {
//	private Connection conn = null;
//	private PreparedStatement psta = null;
//	private ResultSet rs = null;
//	
//	public Connection getConnection() {
//		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
//		String db_name = "sa";
//		String db_password = "sa";
//		
//		try {
//			Class.forName(driveClass);
//			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
//			System.out.println("DB connection success");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 	
//		return conn;
//	}
//	
//	public void closeAll() {
//		try {
//			if (conn != null) {
//				conn.close();
//				conn = null;
//			}
//			if (psta != null) {
//				psta.close();
//				psta = null;
//			}
//			if (rs != null) {
//				rs.close();
//				rs = null;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int updateDB(String sql, Object...obj) {
//		int count = -1;
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			count = psta.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeAll();
//		}
//		return count;
//	}
//	
//	public ResultSet queryDB(String sql, Object...obj) {
//		try {
//			psta = getConnection().prepareStatement(sql);
//			if (obj != null && obj.length > 0) {
//				for (int i = 0; i < obj.length; i++) {
//					psta.setObject(i+1, obj[i]);
//				}
//			}
//			rs = psta.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
//}

public class DBManager {
	private Connection conn = null;
	private PreparedStatement psta = null;
	private ResultSet rs = null;
	
	public Connection getConnection() {
		String driveClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=schoolmis_new";
		String db_name = "sa";
		String db_password = "sa";
		
		try {
			Class.forName(driveClass);
			conn = DriverManager.getConnection(connectionUrl, db_name, db_password);
			System.out.println("DB connection success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
			if (psta != null) {
				psta.close();
				psta = null;
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int updateDB(String sql, Object...obj) {
		int count = -1;
		try {
			psta = getConnection().prepareStatement(sql);
			if (obj != null && obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					psta.setObject(i+1, obj[i]);
				}
			}
			count = psta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return count;
	}
	
	public ResultSet queryDB(String sql, Object...obj) {
		try {
			psta = getConnection().prepareStatement(sql);
			if (obj != null && obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					psta.setObject(i+1, obj[i]);
				}
			}
			rs = psta.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}