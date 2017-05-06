<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<security:authorize access="hasAnyRole('ADMIN','USER')" var="isUSer"/>
<html>
<head>
</head>
<body>
<div id="header" align="center" style="font-weight:bold">


    <c:if test="${not isUSer}">
        <li style="padding-top: 15px; padding-bottom: 15px; color: red">
            <c:if test="${empty param.error}">
                Вы не вошли в приложение
            </c:if>
        </li>
        <li><a style="color: Green;" href="<c:url value= "/login.html"/>">Login</a></li>
    </c:if>

    <c:if test="${isUSer}">
        <li style="padding-top: 15px; padding-bottom: 15px; color: green">
            Вы вошли как:
            <security:authentication property="principal.username"/> с ролью:
            <b><security:authentication property="principal.authorities"/></b>

        </li>
        <li><a style="color: red;" href="<c:url value= "/j_spring_security_logout"/>">Logout</a></li>
    </c:if>

</div>
</body>
</html>
