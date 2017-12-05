<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>BPI Forex Web Application</title>
</head>
<body>
	<img src="images/bpi.JPG" alt="Missing BPI image"/>
	<h1>Welcome to BPI Foreign Exchange Currency Conversion</h1>
	<p><i>Please enter the required values.</i></p>
	
	<form action="processconversion.do" method="post">
		<p>Enter Philippine peso amount: <input type="number" 
			name="phpAmount" min="1000" required="required"/>
		<p>Enter Currency Type: <input type="text" 
			name="currencyType" required="required"/>
		<input type="submit" value="Convert Amount">		
	</form>
	
</body>
</html>