package com.jspiders.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String user = "root";
		String pass = "root";
		String query = "insert into employee values(118,'Mukesh',2343567699,'Mohali'),(119,'Pratik',6754341233,'Chennai')";
		
		Class.forName(className);
		Connection c = DriverManager.getConnection(url, user, pass);
		
		Statement st = c.createStatement();
		
		st.execute(query);
		System.out.println("Data Inserted");
		c.close();
	}
}
