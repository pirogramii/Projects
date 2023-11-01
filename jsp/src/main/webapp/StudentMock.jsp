<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Mock</title>
<style type="text/css">
	#box{
		border: 1px solid blue;
		height:300px;
		width:600px;
		margin:auto ;
		display:flex;
		align-items:center;
		justify-content:center;
	}
	
</style>
</head>
<body>
	<div id="box">
	<table cellspacing="15px">
		<form action="StudentMockOperation.jsp" method="post"> 
			<tr>
				<td>Student ID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Student Email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Mock1 Rating :</td>
				<td><input type="text" name="mock"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</form>
	</table>
	</div>
</body>
</html>