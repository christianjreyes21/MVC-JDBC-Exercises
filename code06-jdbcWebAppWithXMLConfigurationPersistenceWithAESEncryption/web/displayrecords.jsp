<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="talaan" type="java.sql.ResultSet" scope="request"/>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Database Records</title>
</head>
<body>
	<h1>List of Employee Records</h1>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Position</th>
			<th>Department</th>
		</tr>
		<% while (talaan.next()) { %>
			<tr>
				<td><%=talaan.getInt("ID") %></td>
				<td><%=talaan.getString("LASTNAME")%></td>
				<td><%=talaan.getString("FIRSTNAME") %></td>
				<td><%=talaan.getString("YEARLEVEL") %></td>
				<td><%=talaan.getString("COURSE") %></td>
			</tr>
		<% } %>	
	</table>
</body>
</html>