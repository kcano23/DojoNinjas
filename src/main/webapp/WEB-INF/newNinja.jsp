<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/">Home</a>
	<br>
	<h1>New Ninja</h1>
	<form:form action="/ninja/create" method="post" modelAttribute="addNinja">
		<form:input path="first_name" placeholder="First Name..."/>
		<form:errors path="first_name" class="text-danger" /><br>

		<form:input path="last_name" placeholder="Last Name..."/>
		<form:errors path="last_name" class="text-danger" /><br>

		<form:input type = "number" path="age" placeholder="Age..."/>
		<form:errors path="age" class="text-danger" /><br>
		<select name="dojo">
			<c:forEach items="${allDojos}" var = "dojo">
				<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
		</select><br>

		<input type="submit" value="Add a Ninja" class="btn btn-sm btn-primary" />
    </form:form>
</body>
</html>