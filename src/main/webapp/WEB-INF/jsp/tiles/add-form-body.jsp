<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="html" uri="/WEB-INF/tld/struts-html.tld" %>
<%@ taglib prefix="bean" uri="/WEB-INF/tld/struts-bean.tld" %>
<%@ taglib prefix="nested" uri="http://jakarta.apache.org/struts/tags-nested" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://jakarta.apache.org/struts/tags-html" %>
<jsp:useBean id="now" class="java.util.Date" scope="request"/>
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
        <input type="date" readonly value="<fmt:formatDate type="date" value="${now}"/>" size="10" maxlength="10"/>


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