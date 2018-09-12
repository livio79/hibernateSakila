package com.livio.jdbc; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
		String user = "root";
		String pass = "password";
		System.out.println("Go!");
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =	DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
