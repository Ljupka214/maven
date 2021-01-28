package com.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements AutoCloseable {
	private Connection conn;

	public DB() {
		String ip = "127.0.0.1";
		int port = 5432;
		String dbName = "fullstack";
		String username = "postgres";
		String password = "20049";
		String url = "jdbc:postgresql://" + ip + ':' + port + '/' + dbName;

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (IllegalArgumentException | SecurityException | SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		return conn;
	}

	@Override
	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
