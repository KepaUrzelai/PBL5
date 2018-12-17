<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="edu.mondragon.entity.*" %>

<article>
<fmt:bundle basename="resources.View">
<c:choose>
	<c:when test="${not empty requestScope.user}">
		<h1>Edit User:</h1>
		<form action="UserEdit" method="post">
		<input type="hidden" name="userId" value="<c:out value="${requestScope.user.userId}"/>"/>
		
	</c:when>
	<c:otherwise>
		<h1>Register User:</h1>
		<form action="UserRegister" method="post">
	</c:otherwise>
</c:choose>
<table>
<tr>
	<td><label for="username">Username:</label></td>
	<td><input id="username" type="text" name="username" value="${requestScope.user.username}" required/></td>
</tr>
<tr>
	<td><label for="password">Password:</label></td>
	<td><input id="password" type="password" name="password" value="${requestScope.user.password}" required/></td>
</tr>
<tr>
	<td><label for="firstName">Email:</label></td>
	<td><input id="firstName" type="text" name="firstName" value="${requestScope.user.email}" required/></td>
</tr>
<tr>
	<td><label for="secondName">Direction:</label></td>
	<td><input id="secondName" type="text" name="secondName" value="${requestScope.user.direction}" required/></td>
</tr>

</table>
<button type="Submit" name="action" value="save"><fmt:message key="action.save"/></button>
</form>
</fmt:bundle>
</article>
