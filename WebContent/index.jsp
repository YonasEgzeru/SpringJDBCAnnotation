<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
</head>
<body>
	Home page:<h4>List of Users</h4>
	<hr />
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Password</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${users}" var="user">
		<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>