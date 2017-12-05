<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="recordStudents" type="java.sql.ResultSet" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UST 3CSA Students Listing</title>
</head>
<body>
	<h1>Students Listing</h1>
	
	<table border="1" width="100%" cellpadding="3" cellspacing="3">
		<tr>
			<th align="center">ID</th>
			<th align="center">Last Name</th>
			<th align="center">First Name</th>
			<th align="center">Year Level</th>
			<th align="center">Course</th>
			<th align="center">Action-Edit</th>
			<th align="center">Action-Delete</th>
		</tr>
		
			<% 
				while(recordStudents.next()) {	
			%>
				<tr>
					<td><%=recordStudents.getInt("id")%></td>
					<td><%=recordStudents.getString("lastname")%></td>
					<td><%=recordStudents.getString("firstname")%></td>
					<td><%=recordStudents.getString("yearlevel")%></td>
					<td><%=recordStudents.getString("course")%></td>
					<td align="center">
					  <a href="studentmaintenance.html?id=<%=recordStudents.getInt("id")%>&action=edit" method="post">
					  	<img src="images/Editor.ico"/>
					  </a>
					</td>
					<td align="center">
					  <a href="studentmaintenance.html?id=<%=recordStudents.getInt("id")%>&action=delete">
					  	<img src="images/busy.ico"/>
					  </a>
					</td>
				</tr>			
	<% } %>
		
	</table>
</body>
</html>