<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information</title>
</head>
<body>
	<div align="center">
		<a href="UserController?action=add">Add User</a>
	</div>
	<a href="home.jsp">Back Home!</a>
	<br>
	<br>

	<%
		if (session.getAttribute("userId") == null) {

			response.sendRedirect("index.jsp");
		}
	%>
	<h2 align="center">User List</h2>

	<table align="center" cellpadding="5" cellspacing="5" border="1">

		<tr bgcolor="grey">
			<td><b style="color: whitesmoke;">Id</b></td>
			<td><b style="color: whitesmoke;">User Name</b></td>
			<td><b style="color: whitesmoke;">UserId</b></td>
			<td><b style="color: whitesmoke;">Action</b></td>
		</tr>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.userId}" /></td>
					<td><a
						href="UserController?action=upd&id=<c:out value="${user.id}"/>">Edit</a>
						<a
						href="UserController?action=delete&id=<c:out value="${user.id}"/>"
						onclick="return confirm ('Are you sure you want to delete this information?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>