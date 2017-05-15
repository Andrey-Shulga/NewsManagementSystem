<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
    <spring:url value="/resources/css/signin.css" var="signin"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${signin}" rel="stylesheet"/>
</head>
<body>
<div id="header" align="center" style="font-weight:bold">

    <security:authorize access="hasAnyRole('ADMIN','USER')" var="isUSer"/>


    <div align="left">
        <c:if test="${not isUSer}">

            <c:if test="${empty param.error}">
                <bean:message key="not.auth.message"/>
            </c:if><br>

            <a style="color: Green;" href="<c:url value= "/login.html"/>"><bean:message key="login.link"/></a>
        </c:if>

        <c:if test="${isUSer}">

            <bean:message key="user.label"/>
            <b><security:authentication property="principal.username"/></b><br>

            <a href="<c:url value= "/logout"/>"><bean:message key="logout.link"/></a>
        </c:if>
        <h1 align="center"><bean:message key="header.label"/></h1>
        <br>

        <html:link page="/Locale.do?locale=ru">Русский</html:link>
        <html:link page="/Locale.do?locale=en">English</html:link></div>
</div>
</body>
</html>
