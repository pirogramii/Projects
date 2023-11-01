<%@ page language="java" import="java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.SQLException" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Inserted</title>
</head>
<body>
	<%!  String url = "jdbc:mysql://localhost:3306/wejm5?user=root&password=root" ;
		 Connection connection = null ; 
		 PreparedStatement preparedStatement = null ;
		 int result = 0 ;
		 String query = null ;
	%>
	<% String id = request.getParameter("id");
	   String name = request.getParameter("name");
	   String email = request.getParameter("email");
	   String mock = request.getParameter("mock");
	%>
	<% 
	  try{
		  Class.forName("com.mysql.cj.jdbc.Driver"); 
		   connection = DriverManager.getConnection(url);
		    
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	%>
	<%
	   query = "insert into student_mock values(?,?,?,?)";
	   preparedStatement = connection.prepareStatement(query);
	   preparedStatement.setString(1,id);
	   preparedStatement.setString(2,name);
	   preparedStatement.setString(3,email);
	   preparedStatement.setString(4,mock);
	   
	   result = preparedStatement.executeUpdate(); 
	%>
	<% if(result != 0){ %>
	
		<h1><%= "Records Inserted Succesfully!!" %></h1>
		
	<% } else {%> 
	
		<h1><%= "Records Not Inserted !!" %></h1>
		
	<%} %>
</body>
</html>