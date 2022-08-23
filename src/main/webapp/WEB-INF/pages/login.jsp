<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login page</h1>
	<form:form action="login" method="POST">
		<label>Username : </label>
		<input type="text" name="email">
		<label>Password : </label>
		<input type="password" name="password">		
		<input type="submit" value="Login">
	</form:form>
</body>
</html>