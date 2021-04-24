<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/dojo/new">Add a Dojo</a><br>
	<a href="/ninja/new">Add a Ninja</a>
	<br>
	<h1>Hello World!!!</h1>

	<ul>
		<c:forEach items="${allDojos}" var="dojo">
			<li><a href="/dojos/${dojo.id}">${dojo.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>