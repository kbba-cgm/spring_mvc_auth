<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="card">
	<div class="card-body">
	
		<h2>Edit Post</h2>
		<form:form action="${pageContext.request.contextPath}/update" modelAttribute="userDto" method="post">
			<form:hidden path="id" /> 
			
			<div class="form-input">
				<form:label path="name">Username</form:label>
				<form:input path="name" class="form-control" /> 
				<form:errors class="text-danger" path="name" />
			</div>
			
			<div class="form-input">
				<form:label path="email">Email</form:label>
				<form:textarea path="email"  class="form-control" /> 
				<form:errors class="text-danger" path="email" />
			</div>
			
			<div class="form-input">
				<form:label path="password">Body</form:label>
				<form:textarea path="password"  class="form-control" /> 
				<form:errors class="text-danger" path="password" />
			</div>
			
			<div class="form-input">
				<input class="btn btn-warning" type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
</div>
</body>
</html>