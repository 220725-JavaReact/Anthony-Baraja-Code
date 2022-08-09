package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory() {
		
	}
	
	/**
	 * Lazy Loading, for getting the Connection Factory Instance when needed.
	 * @return connectionFactory
	 */
	public static ConnectionFactory getInstance() {
		if(connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(StoreSecretClass.url, StoreSecretClass.username, StoreSecretClass.pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}
}
