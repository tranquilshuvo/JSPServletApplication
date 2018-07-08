<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Update</title>
</head>
<body>
<div align="center">
<form action="UserController" method="post" >
 
		User ID:<br><input type="text" readonly="readonly" name="id"  value="<c:out value="${users.id}" />" /> <br/><br>
        Name:<br /> <input type="text" name="userName" value="<c:out value="${users.userName}" />"/><br><br>
		User ID:<br /> <input type="text" name="userId" value="<c:out value="${users.userId}" />"/><br><br> 
		Password:<br /> <input type="password" name="password" value="<c:out value="${users.password}" />" /><br>
		<br>
		<input name="Register" type="submit" value="Update User" />
		<input type="reset" value="Reset">

	</form><br><br>
	<a href="UserController?action=list">Back User List</a><br>
	</div>
</body>
</html>