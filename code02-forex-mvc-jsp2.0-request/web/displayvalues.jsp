<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BPI Forex Web Application</title>
</head>
<body>
	<img src="images/bpi.JPG" alt="Missing BPI image"/>
	<h1>Welcome to BPI Foreign Exchange Currency Conversion</h1>
	
	<h2>Display values using JSP Expression Language - Form 1</h2>
	<p>The Philipine peso amount of <b>${forexObj.phpAmount}</b> 
		is in <b>${forexObj.currencyType}${forexObj.convertedAmount}</b>		
	<hr/>
	<h2>Display values using JSP Expression Language - Form 2</h2>
	<p>The Philipine peso amount of <b>${forexObj['phpAmount']}</b> 
		is in <b>${forexObj['currencyType']}${forexObj['convertedAmount']}</b>
	<hr/>
	<form action="index.jsp" method="post">
		<input type="submit" value=" << GO BACK >>">		
	</form>	
</body>
</html>