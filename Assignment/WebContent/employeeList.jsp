<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
</head>
<body>

<%
		if(session.getAttribute("userId")==null){
			
			response.sendRedirect("index.jsp");
		}
	
	
	%>

<a href="home.jsp">Back Home!</a><br><br>
<div align="center">
	<a href="EmployeeController?action=add">Add Employee</a>
	</div>
<h2 align="center">Employee List</h2>


<table align="center" cellpadding="5" cellspacing="5" border="1">

<tr bgcolor="green">
<td><b style="color:whitesmoke;">Sl No.</b></td>
<td><b style="color:whitesmoke;">Employee Name</b></td>
<td><b style="color:whitesmoke;">Designation</b></td>
<td><b style="color:whitesmoke;">Department</b></td>
<td ><b style="color:whitesmoke;">UserId</b></td>
<td ><b style="color:whitesmoke;">Action</b></td>
</tr>
<tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td><c:out value="${employee.sl}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.designation}" /></td>
                    <td><c:out value="${employee.department}" /></td>
                    <td><c:out value="${employee.userId}" /></td>
       				 <td><a href="EmployeeController?action=upd&sl=<c:out value="${employee.sl}"/>">Edit</a>
                    <a href="EmployeeController?action=delete&sl=<c:out value="${employee.sl}"/>"onclick="return confirm ('Are you sure you want to delete this information?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        
</table>
	
</body>
</html>