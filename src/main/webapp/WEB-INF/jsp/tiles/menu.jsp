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
    <html:link action="/News.do?method=list"><bean:message key="menu.news.list.link"/></html:link><br><br>
    <html:link action="/News.do?method=showNewsForm"><bean:message key="menu.add.news.link"/></html:link>
</div>
</body>
</html>
