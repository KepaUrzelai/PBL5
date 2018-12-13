<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Log in</title>
</head>
<body>
	<h3>Log in</h3>
	<form:form method="post" action="viewLogin.html">
	<table>
		<tr>
			<td><form:label path="username">User name:</form:label></td>
			<td><form:input path="username" /></td> 		
		</tr>
			<tr>
			<td><form:label path="password">Password:</form:label></td>
			<td><form:input path="password" type="password" /></td>
		</tr>
			<tr>
			<td colspan="2">
				<input type="submit" value="Log in"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>