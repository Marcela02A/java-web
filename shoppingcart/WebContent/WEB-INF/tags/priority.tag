<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="user" required="true"
	type="com.cars.controller.InfoUser"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="priorityOne" fragment="true"%>
<%@ attribute name="priorityTwo" fragment="true"%>
<%@ variable name-given="description"%>
<%@ variable name-given="priority"%>

<ul>
	<c:forEach items="${user.all}" var="alld">
		<c:set var="description" value="${alld.description}" />
		<c:set var="priority" value="${alld.priority}" />
		<c:if test="${alld.priority ==1}">
		<jsp:invoke fragment="priorityOne" />
		</c:if>
		<c:if test="${alld.priority >1}">
		<jsp:invoke fragment="priorityTwo" />
		</c:if>
	</c:forEach>
</ul>