package jdbc_curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {

	private static Connection connection ;
	private static Statement statement ;
	private static PreparedStatement preparedStatement ;
	private static String query ;
	private static int result ;
	private static ResultSet resultSet ;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?user=root&password=root");
		statement = connection.createStatement();
		
		query = "create table customer (cust_id int(5) primary key ," + " cust_name varchar(10) , cust_location varchar(15))";
		result = statement.executeUpdate(query);
		System.out.println("Table created successfully...");
		result = 0 ;
		
		query = "insert into customer values (?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.println("Enter id for customer "+i);
			preparedStatement.setInt(1, sc.nextInt());
			System.out.println("Enter name for customer "+i);
			preparedStatement.setString(2, sc.next());
			System.out.println("Enter location for customer "+i);
			preparedStatement.setString(3, sc.next());
			
			result = result + preparedStatement.executeUpdate();
		}
		System.out.println(result+" records inserted successfully..!!");
		result = 0 ;
		
		query = "select * from customer";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
		}
		
		query = "update customer set cust_location = ? where cust_id = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter the new location : ");
		preparedStatement.setString(1, sc.next());
		System.out.println("Enter the id : ");
		preparedStatement.setInt(2, sc.nextInt());
		result = result + preparedStatement.executeUpdate();
		System.out.println(result+" records are updated..");
		result = 0 ;
		
		query = "select * from customer";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
		}
		
		query = "delete from customer where cust_id = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter id to delete record : ");
		preparedStatement.setInt(1, sc.nextInt());
		result = result + preparedStatement.executeUpdate();
		System.out.println(result+" records are deleted..");
		result = 0 ;
		
		query = "select * from customer";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
		}
		
		connection.close();
	}

}
