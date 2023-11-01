package com.jspiders.jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String user = "root";
		String pass = "root";
		String query = "update employee set ename = 'Harshal' where eid = 118";
		
		Class.forName(className);
		
		Connection c = DriverManager.getConnection(url, user, pass);
		
		Statement st = c.createStatement();
		
		st.execute(query);
		System.out.println("Data Updated Successfully..!!");
		
		c.close();
	}
}
