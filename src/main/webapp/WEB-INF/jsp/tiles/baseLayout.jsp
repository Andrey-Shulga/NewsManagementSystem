<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" ignore="true"/></title>
    <link rel="stylesheet" href="<html:rewrite page='/css/style.css'/>">

</head>

<body>
<tiles:insert attribute="header" ignore="true"/>
<tiles:insert attribute="menu"/>
<tiles:insert attribute="body"/>
<tiles:insert attribute="footer"/>
</body>
</html>
