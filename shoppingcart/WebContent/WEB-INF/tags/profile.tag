<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag body-content="empty"%>
<%@ attribute name="user" required="true"
	type="com.cars.controller.InfoUser"%>
<table class="table table-condensed">
	<tr>
		<td>Name:</td>
		<td>${user._name}</td>
	</tr>
	<tr>
		<td>EMail:</td>
		<td>${user._email}</td>
	</tr>
	<tr>
		<td>Avatar:</td>
		<td><img src="${user.avatar}"/></td>
	</tr>
</table>