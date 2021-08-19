<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method="POST">
		Enter Registration Number : <input type="text" name="regnumber"><br><br>
		Enter E-mail Id : <input type="email" name="mail"><br><br>
		<button type="submit">REGISTER</button>
		
	</form>
	<a href="ShowAllDetails">Show All</a>
</body>
</html>