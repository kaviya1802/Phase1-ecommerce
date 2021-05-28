package com.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	//Init connection
	public Connection connection;
	public DBConnection(String url, String username, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection(url,username,password);
	}
	//get connection
	public Connection getConnection() {
		return connection;
	}
	//close connection
	public void closeConnection() throws SQLException {
		if(this.connection !=null) {
			this.connection.close();		}
	}



}
