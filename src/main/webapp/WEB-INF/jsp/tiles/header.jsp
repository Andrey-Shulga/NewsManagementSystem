<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
</head>
<body>
<div id="header" align="center" style="font-weight:bold">

    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER_USER', 'ROLE_USER')" var="isUSer"/>

    <c:if test="${not isUSer}">
        <li style="padding-top: 15px; padding-bottom: 15px; color: red">
            <c:if test="${empty param.error}">
                Вы не вошли в приложение
            </c:if>
        </li>
        <li><a style="color: Green;" href="<c:url value= "../login.jsp"/>">Login</a></li>
    </c:if>

    <c:if test="${isUSer}">
        <li style="padding-top: 15px; padding-bottom: 15px; color: green">
            Вы вошли как:
            <security:authentication property="principal.username"/> с ролью:
            <b><security:authentication property="principal.authorities"/></b>

        </li>
        <li><a style="color: red;" href="<c:url value= "/j_spring_security_logout"/>">Logout</a></li>
    </c:if>


    <h1><bean:message key="header.label"/></h1>
    <br>
    <div align="left">
        <html:link page="/Locale.do?locale=ru">Русский</html:link>
        <html:link page="/Locale.do?locale=en">English</html:link></div>
    </div>
</body>
</html>
