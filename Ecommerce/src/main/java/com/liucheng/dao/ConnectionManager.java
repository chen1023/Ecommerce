package com.liucheng.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionManager {
	// Á¬½Ómysql
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null && (!conn.isClosed())) {
				conn.close();
			}
			if (ps != null && (!ps.isClosed())) {
				ps.close();
			}
			if (rs != null && (!rs.isClosed())) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
