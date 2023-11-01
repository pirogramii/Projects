package com.jspiders.jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String user = "root";
		String pass = "root";
		String query = "delete from employee where eid = 118";
		
		Class.forName(className);
		
		Connection c = DriverManager.getConnection(url, user, pass);
		
		Statement st = c.createStatement();
		
		int res = st.executeUpdate(query);
		if(res==1)
			System.out.println("Deleted");
		else
			System.out.println("Not Deleted");
		
		c.close();
	}
}
 