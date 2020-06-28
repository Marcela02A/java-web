<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>${initParam.productName}</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" type="text/css">
</head>
<body>
	<%@include file="header.jsp"%>
	<form action="home" method="post">
		<p>
			name:<input type="text" name="name" />
		</p>
		<p>
			<input type="submit" value="Enter name">
		</p>
	</form>

	<tabset>
	<h2>Welcolme ${user._name} ${param.user}</h2>
	</tabset>

</body>
</html>