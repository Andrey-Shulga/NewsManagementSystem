<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div id="menu" align="center">
    <a href="/news-list"><bean:message key="menu.news.list.link"/></a><br><br>
    <a href="/news-form"><bean:message key="menu.add.news.link"/></a>
</div>
</body>
</html>
