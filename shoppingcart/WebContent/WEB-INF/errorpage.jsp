<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
</head>
<body>
	<h2>Error Page</h2>
	<%= exception.getMessage() %>
	<%= exception.toString() %>
</body>
</html>