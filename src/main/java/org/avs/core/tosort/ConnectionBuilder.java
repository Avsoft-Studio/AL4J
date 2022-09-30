package org.avs.core.tosort;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Connection;

public class ConnectionBuilder {
	private static volatile ConnectionBuilder connection = null;
	private Connection instance = null;

	private ConnectionBuilder(String url, String user, String pwd) throws SQLTimeoutException, SQLException{
		instance = (Connection) DriverManager.getConnection(url, user, pwd);
	}

	public static ConnectionBuilder getInstance(String url, String user, String pwd) {
		if (ConnectionBuilder.connection == null) {
			synchronized (ConnectionBuilder.class) {
				if (ConnectionBuilder.connection == null) {
					try { connection = new ConnectionBuilder(url, user, pwd); } 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return connection;
	}

	public Connection getConnection() {
		return instance;
	}
}
