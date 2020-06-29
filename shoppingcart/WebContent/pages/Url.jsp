<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Terminamos</h1>
<a href="Home.jsp">linkOne</a>
<a href="/Home.jsp">linkTwo</a>
<c:url var="login" value="/Home.jsp"></c:url>
<a href="${login}">linkThree</a>
