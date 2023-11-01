package com.jspiders.jdbc.fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeFetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		String query = "select * from emp";
		
		Class.forName(className);
		Connection c = DriverManager.getConnection(url);
		Statement st = c.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int numberOfColumns = rsMetaData.getColumnCount();
		for(int i = 1 ; i <= numberOfColumns ; i++) {
			System.out.print(rsMetaData.getColumnName(i)+" ");
		}
		System.out.println();
		System.out.println("============================");
		System.out.println("============================");
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			System.out.println("============================");
		}
		c.close();
	}
}
