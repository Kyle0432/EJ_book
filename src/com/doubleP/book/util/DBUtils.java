package com.doubleP.book.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 通用数据库工具类
 * @author 2018-3-13
 */
public class DBUtils {
	/** 数据库驱动类型 */
	static String DRIVER;
	/** 数据库服务器地址 */
	static String DB_URL;
	/** 数据库登录用户 */
	static String DB_NAME;
	/** 数据库登录密码 */
	static String DB_PWD;

	static {//类的静态程序段会在初次实例化时执行，且仅执行一次
		try {	//读取数据库配置文件，初始化数据库驱动、地址、用户和密码
			Properties pro = new Properties();
			pro.load(DBUtils.class.getResourceAsStream("/conn.properties"));
			DRIVER = pro.getProperty("DRIVER");
			DB_URL = pro.getProperty("DB_URL");
			DB_NAME = pro.getProperty("DB_NAME");
			DB_PWD = pro.getProperty("DB_PWD");
			Class.forName(DRIVER);//加载数据库驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接数据库
	 * 
	 * @return 返回conn
	 * @throws SQLException
	 *             抛出异常
	 */
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
	}

	/**
	 * 查询
	 * 
	 * @param sql
	 *            查询语句
	 * @param args
	 *            查询条件
	 * @return 返回map集合结果
	 */
	public static Map<String, Object> query(String sql, Object... args) {
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pst = conn.prepareStatement(sql);
			if (args != null)
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
			rs = pst.executeQuery();
			if (rs.next()) {
				rsToMap(rs, map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pst, rs);
		}
		return map;
	}

	/**
	 * 查询（多个结果）
	 * 
	 * @param sql
	 *            查询语句
	 * @param args
	 *            查询条件
	 * @return 返回List<map>集合结果
	 */
	public static List<Map<String, Object>> queryList(String sql,
			Object... args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pst = conn.prepareStatement(sql);
			if (args != null)
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
			rs = pst.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				rsToMap(rs, map);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pst, rs);
		}
		return list;
	}
	/**
	 * rs记录集转换成map集合
	 * 
	 * @param rs
	 *            查询到的记录集
	 * @param map
	 *            转换后的map集合
	 */
	private static void rsToMap(ResultSet rs, Map<String, Object> map)
			throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		for (int i = 1; i <= count; i++) {
			String key = rsmd.getColumnName(i);
			Object value = rs.getObject(i);
			map.put(key, value);
		}
	}

	/**
	 * 执行增删改SQL语句
	 * 
	 * @param sql 增删改SQL
	 * @param args 增删改的条件
	 * @return 执行成功返回true,否则返回false
	 */                                      //Object[] args
	public static boolean update(String sql, Object... args) {
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = getConn();
			pst = conn.prepareStatement(sql);
			for (int i = 0; args != null && i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
			int retInt = pst.executeUpdate();
			return retInt > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pst, null);
		}
		return false;
	}
	/**
	 * 关闭资源
	 */
	private static void close(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
