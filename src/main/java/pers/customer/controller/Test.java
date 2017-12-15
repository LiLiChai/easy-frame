package pers.customer.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";   
		String password = "316412316";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("ok");
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			con.close();
		} catch (Exception e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} 
	}

}