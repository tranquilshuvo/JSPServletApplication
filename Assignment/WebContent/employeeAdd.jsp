<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="javaDBUtil.DBUtil"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>

 <script type="text/javascript">
		function ckeckForm(form){
			if(form.name.value==""){
				
				alert("Error: Name is empty!");
				form.name.focus();
				return false;
			}
				if(form.designation.value==""){
				
				alert("Error: Designation is empty!");
				form.designation.focus();
				return false;
			}
				if(form.department.value==""){
					
					alert("Error: Department is empty!");
					form.department.focus();
					return false;
				}
					if(form.userId.value==""){
					
					alert("Error: User ID is empty!");
					form.userId.focus();
					return false;
				}
		}	
 
 
</script>
</head>
<body>
	<%
		DBUtil db = new DBUtil();
		Connection connection = db.getConnection();
	%>
	<div align="center">
	<form action="EmployeeController" method="post" onsubmit="return ckeckForm(this);">
		<input type="hidden" name="action" value="add" /> Sl no.:<br> 
		<input type="text" readonly="readonly" name="sl" /> <br /> <br> Name:<br />
		<input type="text" name="name" /><br> <br> Designation:<br />
		<input type="text" name="designation" /><br> <br> Department:<br /> 
		<input type="text" name="department" />
		<br> <br>
		<br> User ID:<br> <br> 
		<select class="form-control" style="width: 250px;" name="userId">
			<option>Select User Name</option>

			<%
				try {
					String sql = "select * from userinfo";
					Statement stm = connection.createStatement();
					ResultSet rs = stm.executeQuery(sql);

					while (rs.next()) {
			%>
			<option value="<%=rs.getInt("id")%>"><%=rs.getString("userName")%></option>
			<%
				}

				} catch (Exception ex) {
					ex.printStackTrace();

				}
			%>

		</select> <br> <br> 
		<input name="Register" type="submit" value="Add Employee" /> 
		<input type="reset" value="Reset">

	</form><br><br>
	
	<a href="EmployeeController?action=list">Back Employee List!</a><br><br>
	</div>
</body>
</html>