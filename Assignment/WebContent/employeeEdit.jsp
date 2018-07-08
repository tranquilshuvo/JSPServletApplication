<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Update</title>
</head>
<body>
<div align="center">
	<form action="EmployeeController" method="post" >
 
		 ID:<br><input type="text" readonly="readonly" name="sl"  value="<c:out value="${employees.sl}" />" /> <br /> <br>
             
		Name:<br /> <input type="text" name="name" value="<c:out value="${employees.name}" />"/><br>
		<br> Designation:<br /> <input type="text" name="designation" value="<c:out value="${employees.designation}" />"/>
		<br>
		<br> Department:<br /> <input type="text" name="department" value="<c:out value="${employees.department}" />"/><br>
		
		<br> 
		<br>
		<br> User ID:<br /> <input type="text" name="userId" value="<c:out value="${employees.userId}" />"/><br>
		
		<br> 
		
		<input name="Register" type="submit" value="Update Employee" />
		<input type="reset" value="Reset">

	</form><br><br>
	<a href="EmployeeController?action=list">Back Employee List!</a>
	</div>
</body>
</html>