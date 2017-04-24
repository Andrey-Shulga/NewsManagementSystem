<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
</head>
<body>
<div id="header" align="center" style="font-weight:bold"><h1><bean:message key="header.label"/></h1>
    <br>
    <div align="left">
        <html:link page="/Locale.do?locale=ru">Русский</html:link>
        <html:link page="/Locale.do?locale=en">English</html:link></div>
    </div>
</body>
</html>
