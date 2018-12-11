<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<header id="header">
        <tiles:insertAttribute name="header" />
    </header>
 
    <section id="menubar">
        <tiles:insertAttribute name="menuBar" />
    </section>
         
    <section id="leftbar">
        <tiles:insertAttribute name="filters" />
    </section>
    
    <section id="main">
        <tiles:insertAttribute name="body" />
    </section>
     
    <footer id="footer">
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>