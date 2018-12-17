<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title" ignore="true"/></title>
</head>
<body>
	<header id="header">
        <tiles:insertAttribute name="header" />
    </header>

    <section id="main" style="float:left;padding:10px;width:80%;border-left:1px solid pink;">
        <tiles:insertAttribute name="body" />
    </section>
     
    <footer id="footer" style="clear:both">
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>