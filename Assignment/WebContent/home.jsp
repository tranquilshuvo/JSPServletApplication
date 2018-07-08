<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%
		if((session.getAttribute("userId")==null)|| (session.getAttribute("userId")==null)){
			
			response.sendRedirect("index.jsp");
		}
	
	
	%>

<h3 align="center">Home Page</h3>
<div align="center">

<form action="Logout" >

<a href="UserController?action=list">User Management</a><br>
<a href="EmployeeController?action=list">Employee Management</a>
<br><br>




<input type="submit" value="Logout"/>

</form>
</div>
</body>
</html>