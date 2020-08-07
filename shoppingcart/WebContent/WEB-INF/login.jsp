<%@page import="java.util.Calendar"%>
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://carlos/tag"%>
<%@taglib prefix="s" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>${initParam.productName}</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" type="text/css">

<style type="text/css">
.blueUser {
	border: 1px solid black;
	background-color: lightblue;
}

.redUser {
	border: 1px solid black;
	background-color: lightcoral;
}

.priorityTwo {
	border: 1px solid black;
	background-color: red;
}
</style>
</head>
<body>
	<%-- 	<%@include file="header.jsp"%> --%>
	<c:import url="header.jsp" var="_header" />
	${_header}
	<section class="main container-fluid">
		<%
			Calendar calendar = Calendar.getInstance();
		%>

		<div class="container">
			<h1>Home</h1>
			<div class="row-fluid">
				<div class="col-md-3">
					<c:out value="hello world!!" />
					<br />
					<%=calendar.getTime().toString()%>
				</div>
			</div>
		</div>

		<div class="col-md-9">
			<ul>
				<m:beautyRepeat beauty="15">
					<li><m:beautiful /></li>
				</m:beautyRepeat>
			</ul>
			<ul class="nav nav-tabs">
				<c:forEach items="${app.tabs.values()}" var="tab">
					<li><a href="${tab.url}" data-toggle="tab" class="ml-2">${tab.name}</a></li>
				</c:forEach>

				<%-- 						<li><a href="#home" data-toggle="tab" class="ml-2">${app.tabNames[0]}</a></li> --%>
				<%-- 						<li><a href="#other" data-toggle="tab" class="ml-2">${app.tabNames[1]}</a></li> --%>
				<%-- 						<li><a href="#messages" data-toggle="tab" class="ml-2">${app.tabNames[2]}</a></li> --%>
				<%-- 						<li><a href="#setting" data-toggle="tab" class="ml-2">${app.tabNames[3]}</a></li> --%>
			</ul>
			<div class="tab-content"></div>
			<div class="tab pane active" id="home">
				<ul>
					<s:priority user="${user}">
						<jsp:attribute name="priorityOne">
							<li> <span>${description}</span>
							     <span>${priority}</span>
							</li>
							</jsp:attribute>
						<jsp:attribute name="priorityTwo">
							<li class="priorityTwo"> 
									<span>${description}</span>
							     	<span>${priority}</span>
							</li>
							</jsp:attribute>
					</s:priority>
				</ul>
			</div>
			<form action="home" method="post">
				<p class="${app['formCssClass']['name']}">
					<c:if test="${!empty user._name}">
						<h2>welcome ${user._name}</h2>
					</c:if>
					<c:if test="${empty user._name}">
						<h2>welcome whoever you ${user._name}</h2>
					</c:if>
					name:<input type="text" name="name" />
				</p>
				<p>
					<input type="submit" value="Enter name">
				</p>
			</form>

			<!-- 					<tabset> -->
			<%-- 					<h2>Welcolme ${user._name} ${param.user}</h2> --%>
			<%-- 					<h2>${user.name=="mar"}</h2> --%>
			<!-- 					</tabset> -->
		</div>
		<div>
			<div class="tab-pane active" id="profile">
				<m:helloWorld name="Hassasla"></m:helloWorld>
				<c:if test="${!empty user._name}">
					<s:profile user="${user}" />
				</c:if>
			</div>
			<div>
				<div class="tan-pane" id="setting">setting</div>

			</div>
			<div>
				<div class="tan-pane" id="Messaje">Messages</div>

			</div>
		</div>
	</section>
</body>
</html>