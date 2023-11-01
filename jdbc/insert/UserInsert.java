package com.jspiders.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/userdb?user=root&password=root";
		Class.forName(className);
		Connection c = DriverManager.getConnection(url);
		Statement st = c.createStatement();
		st.execute("insert into user values (1,'Pankaj',2378654322,'chhakkapankaj69@gmail.com','Chopda')"
				+ ",(2,'Mayur',3456789765,'mayurdon143@gmail.com','Takli')"
				+ ",(3,'Chetan',2678934411,'chhotachetan69gmail.com','Amalner')");
		
		System.out.println("Data Inserted Successfully..!!");
		
		c.close();
	}
}
