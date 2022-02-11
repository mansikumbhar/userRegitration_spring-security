<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h1>Welcome to Spring Boot Security</h1>

<form method="POST" action="/login">
	User Name : <input type="text" name="username" value="user"/><br><br>
	Password  : <input type="password" name="password" value="password"/><br><br>
	<input type="submit" name="submit"/>
</form>
</center>

</body>
</html>