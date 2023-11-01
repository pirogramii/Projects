package com.jspiders.jdbc.any;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeOperation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb?user=root&password=root";
		
		Class.forName(className);
		Connection c = DriverManager.getConnection(url);
		Statement st = c.createStatement();
		System.out.println("Operations to do: ");
		System.out.println("1. Fetch Data"
				+"\n2. Insert Data"
				+"\n3. Delete Data");
		System.out.print("Enter Your Choice: ");
		int choice = sc.nextInt();
		switch(choice){
		case 1 :
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4));
				System.out.println("************************************");
			}
			break;
		case 2:
			System.out.print("Enter id: ");
			int id = sc.nextInt();
			System.out.print("Enter name: ");
			String name = sc.next();
			System.out.print("Enter phone: ");
			Long phone = sc.nextLong();
			System.out.print("Enter location: ");
			String location = sc.next();
			st.execute("insert into employee values ("+id+",'"+name+"',"+phone+",'"+location+"')");
			System.out.println("Data Inserted Successfully..!!!");
			break;	
		case 3:
			System.out.print("Enter id of row you want to delete: ");
			int id1 = sc.nextInt();
			st.execute("delete from employee where eid = "+id1);
			System.out.println("Data Deleted Successfully..!!");
			break;
		default:
			System.out.println("Enter Valid Choice..!!");
		}
		sc.close();
		c.close();
	}
}
