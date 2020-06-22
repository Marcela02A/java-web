<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<%@include file="/pages/header.jsp" %>
	<form action="home" method="post">
		<p>
			name:<input type="text" name="name" />
		</p>
		<p>
			<input type="submit" value="Enter name">
		</p>
	</form>
	<img src="file?name=<%=request.getParameter("user") %>" alt="img" />
</body>
</html>