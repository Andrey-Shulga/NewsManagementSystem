<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div id="menu" align="center">
    <a href="NewsList.do"><bean:message key="menu.news.list.link"/></a><br><br>
    <a href="AddNewsForm.do"><bean:message key="menu.add.news.link"/></a>
</div>
</body>
</html>
