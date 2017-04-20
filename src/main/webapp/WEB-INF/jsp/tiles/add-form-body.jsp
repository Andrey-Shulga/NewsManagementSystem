<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="html" uri="/WEB-INF/tld/struts-html.tld" %>
<%@ taglib prefix="bean" uri="/WEB-INF/tld/struts-bean.tld" %>
<%@ taglib prefix="nested" uri="http://jakarta.apache.org/struts/tags-nested" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div id="body">
    <html:form action="/AddNews">
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <bean:message key="add.news.label.title"/>
        </div>
        <html:text property="news.title" size="100" maxlength="1000"/>
    </div>
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <bean:message key="add.news.label.date"/>
        </div>

    </div>
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <bean:message key="add.news.label.brief"/>
        </div>
        <html:textarea property="news.brief"/>
    </div>
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <bean:message key="add.news.label.content"/>
        </div>
        <html:textarea property="news.content"/>
    </div>
    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <html:submit>
                <bean:message key="add.news.button.submit"/>
            </html:submit>
        </div>
        <html:reset>
            <bean:message key="add.news.button.cancel"/>
        </html:reset>
        </html:form>
    </div>
</body>
</html>