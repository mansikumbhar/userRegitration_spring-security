<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
 
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>

	<h2>Search Result</h2>


	<div sec:authorize="isAuthenticated()">
		Welcome<b><span sec:authentication="name">Username</span></b> &nbsp;
		<i><span sec:authentication="principal.authorities">Roles</span> </i>
	</div>

	<form th:action="@{/Logout}" method="post">
		<input type="submit" value="Logout" />
	</form>

	<div sec:authorize="hasAnyAuthority('User','ADMIN')">
		<a href="saveUser">Click to add new user</a>
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

		
			<tr th:each="registration : ${registration}">
				<td th:text="${registration.emp_id}">emp_id</td>
				<td th:text="${registration.emp_name}">Emp_name</td>
				<td th:text="${registration.email}">Email</td>
				<td th:text="${registration.city}">City</td>
				<td th:text="${registration.mobile}">Mobile</td>
				<td th:text="${registration.address}">Address</td>
				
				<div sec:authorize="hasAnyAuthority('ADMIN')">
				<td><a href="deleteRegistration?emp_id=${registration.emp_id}">delete</a></td>
				</div>&nbsp;&nbsp;&nbsp;
				<div sec:authorize="hasAnyAuthority('User','ADMIN')">
				<td><a href="updateRegistration?emp_id=${registration.emp_id}">update</a></td>
				</div>
			</tr>

		

	</table>






</body>
</html>