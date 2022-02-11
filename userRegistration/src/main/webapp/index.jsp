<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>

	<h2>Search Result</h2>


	<div sec:authorize="isAuthenticated()">
		Welcome<b><span sec:authentication="name">Username</span></b> &nbsp;
		<i><span sec:authentication="principle.authorities">Roles</span> </i>
	</div>

	<form th:action="@{/Logout}" method="post">
		<input type="submit" value="Logout" />
	</form>

	<div sec:authorize="hasAnyAuthority('User','ADMIN')">
		<a href="/index">Click to add new location</a>
	</div>

	<table border='1'>
		<tr>
			<th>emp_id</th>
			<th>Emp_name</th>
			<th>email</th>
			<th>City</th>
			<th>Mobile</th>
			<th>Address</th>
			<th sec:authorize="hasAnyAuthority('User','ADMIN')">Delete</th>
			<th sec:authorize="hasAnyAuthority('User','ADMIN')">Update</th>
		</tr>

		<c:forEach items="${registration}" var="registration">
			<tr>
				<td>${registration.emp_id}</td>
				<td>${registration.emp_name}</td>
				<td>${registration.email}</td>
				<td>${registration.city}</td>
				<td>${registration.mobile}</td>
				<td>${registration.address}</td>
				
				<div sec:authorize="hasAnyAuthority('ADMIN')">
				<td><a href="deleteRegistration?emp_id=${registration.emp_id}">delete</a></td>
				</div>&nbsp;&nbsp;&nbsp;
				<div sec:authorize="hasAnyAuthority('User','ADMIN')">
				<td><a href="updateRegistration?emp_id=${registration.emp_id}">update</a></td>
				</div>
			</tr>

		</c:forEach>

	</table>






</body>
</html>