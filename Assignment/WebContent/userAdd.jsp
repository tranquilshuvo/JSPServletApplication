<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
 <script type="text/javascript">
		function ckeckForm(form){
			if(form.userName.value==""){
				
				alert("Error: Name is empty!");
				form.userName.focus();
				return false;
			}
				if(form.userId.value==""){
				
				alert("Error: User ID is empty!");
				form.userId.focus();
				return false;
			}
				if(form.password.value==""){
					
					alert("Error: Password is empty!");
					form.password.focus();
					return false;
				}
		}	
 
 
</script> 
</head>
<body>
<div align="center">
<form action="UserController" method="post" onsubmit="return ckeckForm(this);" >
 <input type="hidden" name="action" value="add"/>
		User ID:<br><input type="text" readonly="readonly" name="id"  /> <br /> <br>
             
		Name:<br /> <input type="text" name="userName" /><br>
		<br> User ID:<br /> <input type="text" name="userId" /><br>
		
		<br> Password:<br /> <input type="password" name="password" /><br>
		<br>
		<input name="Register" type="submit" value="Add User" />
		<input type="reset" value="Reset">

	</form><br><br>
	
	<a href="UserController?action=list">Back User List</a><br>
	</div>
</body>
</html>