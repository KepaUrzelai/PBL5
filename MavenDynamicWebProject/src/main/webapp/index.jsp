<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="edu.mondragon.entity.*" %>
<body>
<h2>Hello World!</h2>
<article>
<c:choose>
	<c:when test="${not empty sessionScope.user}">
		<h1><fmt:message key="general.hi"/> <c:out value="${sessionScope.user.username}"/>!</h1>
	</c:when>
	<c:otherwise>
		<h1>Login</h1>
		<form action="Login" method="get">
		<label>Username<input type="text" name="username" required value="<c:out value="${requestScope.username}" default=""/>"/></label><br/>
		<label>Password<input type="password" name="password" required value="<c:out value="${requestScope.password}" default=""/>"/></label><br/>
		<button type="submit" name="action" value="login">Login</button>
		</form>
		<form action="UserRegister" method="get">
			<button type="submit" name="action" value="new">Register</button>
		</form>
	</c:otherwise>
</c:choose>
</article>
</body>
</html>
