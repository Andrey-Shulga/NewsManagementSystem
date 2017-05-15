<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
    <spring:url value="/resources/css/signin.css" var="signin"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${signin}" rel="stylesheet"/>
</head>
<body>
<div id="body">

    <form name="form" action="/login" method="post" class="form-signin">
        <security:authorize access="hasAnyRole('ADMIN','USER')" var="isUSer"/>

        <h2 class="form-signin-heading"><bean:message key="please.login"/></h2>

        <label for="username" class="sr-only"><bean:message key="login.label"/></label>
        <input id="username" class="form-control" name="username" value="" required autofocus/>

        <label for="password" class="sr-only"><bean:message key="passw.label"/></label>
        <input type="password" id="password" class="form-control" name="password" value="" required/>

        <div class="checkbox">
            <label>
                <input type="checkbox" id="rememberme" name="_spring_security_remember_me"/><bean:message
                    key="remember.me"/>
            </label>
        </div>
        <c:if test="${not empty param.error}">
            <span class="error_login" style="font-size: small; color: red; "><b><bean:message key="invalid.login"/></b></span>
        </c:if>
        <input type="submit" value="<bean:message key="login.submit.button"/>" class="btn btn-lg btn-primary btn-block">
        <br/>
        <a href="javascript:history.back()"><bean:message key="back.button"/></a>


    </form>


</div>
</body>
</html>
