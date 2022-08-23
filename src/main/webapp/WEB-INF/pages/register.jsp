<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<h2>Register form</h2>
	<form:form action="register" modelAttribute="userDto">
		<label>Username : </label>
		<form:input type="text" path="name" /> 
		<form:errors path="name" />  
		<label>Email : </label>
		<form:input type="email" path="email" />
		<form:errors path="email" />
		<label>Password : </label>
		<form:input type="password" path="password" />
		<form:errors path="password" />  
		
		<input type="submit" value="Register">
	</form:form>
</body>
</html>