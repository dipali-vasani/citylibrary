package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect2Mysql {

	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:MySQL://localhost:3306/city_library";
	private final String username = "root";
	private final String password = "root1234";
	private Connection conn;
	private Statement statement;

	public Connection Connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("######################");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void CloseConnection() {
		try {
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Statement createStatement() {
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

}