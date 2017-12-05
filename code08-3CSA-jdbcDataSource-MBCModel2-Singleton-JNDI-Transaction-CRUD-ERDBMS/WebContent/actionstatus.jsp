<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Status</title>
</head>
<body>
	<%
	if (request.getParameter("success").equals("true")) { %>
		<h2>Successful Registration</h2>
		<br/>
		<p>Last Name: ${employee.lastName}</p>
		<p>First Name: ${employee.firstName}</p>
		<p>Year Level: ${employee.yearLevel}</p>
		<p>Course: ${employee.course}</p> 
	<% } else { %>
	  <h1>Registration Failed</h1>		
	<% } %> 
	<br/>
	<p><a href="index.jsp">Click here to display the menu.</a></p>
</body>
</html>