<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/">Home</a>
	<br>
	<h1>New Dojo</h1>
	<form:form action="/dojo/create" method="post" modelAttribute="addDojo">
		<form:input path="name" placeholder="Add a Dojo..."/>
		<form:errors path="name" class="text-danger" />
		<input type="submit" value="Add a Dojo" class="btn btn-sm btn-primary" />
    </form:form>
</body>
</html>