package com.jspiders.jdbc.insert;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class EmployeeInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		Statement statement = connection.createStatement();
		
		statement.execute("insert into employee values(118,'Harish',2345612333,'Chandigarh')");
		
		connection.close();
		
		System.out.println("Data inserted successfully..!!");
		
	}
}

