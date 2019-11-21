package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection newConnection() throws SQLException {
		return DriverManager.getConnection("","","");
	}
}
