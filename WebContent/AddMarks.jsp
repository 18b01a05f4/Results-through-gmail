<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align : center;">
		<h2> Enter marks</h2>
		<form action="AddStudentMarks" method="post" style="text-align : center">
			Register Number : <input type="text" name="regnum"><br><br>
					   DWDM : <input type="number" name="dwdm"><br><br>
			        Infosec : <input type="number" name="infosec"><br><br>
			             WT : <input type="number" name="wt"><br><br>
			             CC : <input type="number" name="cc"><br><br>
			            AJP : <input type="number" name="ajp"><br><br>
			           ECom : <input type="number" name="ecom"><br><br>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>