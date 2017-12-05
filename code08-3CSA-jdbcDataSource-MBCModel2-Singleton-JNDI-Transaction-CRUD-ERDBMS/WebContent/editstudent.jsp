<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>3CSA Student Record Update</title>
</head>
<body>
	<h1>3CSA Student Record Update</h1>
	
	<form action="employeeupdate.html" method="post">
		<p>ID:${param.ID}</p>
		<p>Last name: <input type="text" size="25" name="lastName" 
			value=${employee.lastName}/></p>
		<p>First name: <input type="text" size="25" name="firstName" 
			value=${employee.firstName}></p>	
		<p>Year Level: <input type="text" size="25" name="yearLevel" 
			value=${employee.position}/></p>
		<p>Course: <input type="text" size="25" name="course" 
			value=${employee.department}/></p>
		<input type="hidden" name="studentId" 
			value=${param.id}/>
		<input type="submit" value="Update Record">
	</form>
</body>
</html>






