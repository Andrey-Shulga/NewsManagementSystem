<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<security:authorize access="hasAnyRole('ADMIN', 'USER')" var="isUSer"/>
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

        <span style="font-size: x-small; color: red; ">
            <c:if test="${not isUSer}">
                <c:if test="${empty param.error}">
                    Вы не вошли
                </c:if>
            </c:if>
        </span>

        <span style="font-size: x-small; color: green; ">
            <c:if test="${isUSer}">Вы вошли как:
                <security:authentication property="principal.username"/> с ролью:
                <b><security:authentication property="principal.authorities"/></b>
            </c:if>
        </span>
        <br/>
        <c:if test="${not empty param.error}">
            <span style="font-size: x-small; color: red; "><b>Неправильный логин или пароль</b></span>
        </c:if>

        <h2 class="form-signin-heading">Пожалуйста войдите</h2>

        <label for="inputEmail" class="sr-only"><spring:message text="Email"/></label>
        <input id="inputEmail" class="form-control" name="username" value="admin" required autofocus/>

        <label for="inputPassword" class="sr-only"><spring:message text="Password"/></label>
        <input type="password" id="inputPassword" class="form-control" name="password" value="admin" required/>

        <div class="checkbox">
            <label>
                <input type="checkbox" id="rememberme" name="_spring_security_remember_me"/>Запомнить меня
            </label>
        </div>
        <input type="submit" value="Войти" class="btn btn-lg btn-primary btn-block">
        <br/>
        <a href="javascript:history.back()">Назад</a>


    </form>


</div>
</body>
</html>
