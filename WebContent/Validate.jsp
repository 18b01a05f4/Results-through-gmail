<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<body>
	
	<%
		String usrname = request.getParameter("uname");
		String passwrd = request.getParameter("pwd");
		
		if(usrname.equals("admin") && passwrd.equals("admin")) {
			response.sendRedirect("AddMarks.jsp");
		}
		else out.println("Invalid Credentials");
	%>
	
</body>
</html>