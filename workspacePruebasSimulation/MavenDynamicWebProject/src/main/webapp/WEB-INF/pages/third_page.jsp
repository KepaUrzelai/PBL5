<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<tiles-definitions>
    <definition name="template-def"
           template="/WEB-INF/views/tiles/layouts/defaultLayout.jsp">  
        <put-attribute name="title" value="" />  
        <put-attribute name="header"
           value="/WEB-INF/views/tiles/templates/defaultHeader.jsp" />  
        <put-attribute name="menu"
           value="/WEB-INF/views/tiles/templates/defaultMenu.jsp" />  
        <put-attribute name="body" value="" />  
        <put-attribute name="footer"
           value="/WEB-INF/views/tiles/templates/defaultFooter.jsp" />  
    </definition>  
    <definition name="home" extends="template-def">  
        <put-attribute name="title" value="Welcome" />  
        <put-attribute name="body"
           value="/WEB-INF/views/pages/home.jsp" />  
    </definition>  
</tiles-definitions>
</body>
</html>