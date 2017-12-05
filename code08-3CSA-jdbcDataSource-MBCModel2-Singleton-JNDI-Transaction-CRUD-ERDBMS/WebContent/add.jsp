<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Record</title>
</head>
<body>
	<h2>Add Employee Record</h2>
	<form action="processregistration.html" method="post">
		<p>ID: <input type="text" name="ID" size="25" required="required"></p>
		<p>Last Name: <input type="text" name="lastName" size="25" required="required"></p>
		<p>First Name: <input type="text" name="firstName" size="25" required="required"></p>
		<p>Year Level: <input type="text" name="yearLevel" size="25" required="required"></p>
		<p>Course: <input type="text" name="course" size="25" required="required"></p>
		<!--  <input type="hidden" name="action" value="insert">  -->
		<input type="submit" value="Register">
	</form>
</body>
</html>