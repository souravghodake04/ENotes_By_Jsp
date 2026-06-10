package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection conn;

	public static Connection getConn() {

		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection( "jdbc:mysql://acela.proxy.rlwy.net:53504/railway", "root", "EJmCTLpJFfXLkgmCObQDluqxqLwzKgnZ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return conn;
	}
}
