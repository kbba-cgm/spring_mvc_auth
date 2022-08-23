<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h2>HOme page</h2>
	<security:authentication var="user" property="principal" />
	<%-- <sec:authentication property="principal.username" /> --%>
	<security:authorize access="isAuthenticated()">
    logged in as <security:authentication property="principal.username" />
	</security:authorize>

	<security:authorize access="! isAuthenticated()">
    not logged in
</security:authorize>
	<a href="${pageContext.request.contextPath}/edit/${user.id}">Edit</a>
	<form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="logout">
	</form>
</body>
</html>