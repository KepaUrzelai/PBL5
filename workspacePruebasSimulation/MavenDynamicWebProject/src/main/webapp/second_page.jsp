<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Second page using JSTL</title>
</head>
<body>
<h1>Second page using JSTL</h1>
<p><c:out value="${sessionScope.username}" default="Unknown user"/></p>
</body>
</html>