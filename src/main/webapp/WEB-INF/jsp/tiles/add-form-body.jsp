<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="html" uri="/WEB-INF/tld/struts-html.tld" %>
<%@ taglib prefix="bean" uri="/WEB-INF/tld/struts-bean.tld" %>
<%@ taglib prefix="nested" uri="http://jakarta.apache.org/struts/tags-nested" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="htm" uri="http://jakarta.apache.org/struts/tags-html"%>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>

<jsp:useBean id="now" class="java.util.Date" scope="request"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div id="body">

    <html:errors/>
    <html:form action="/AddNews">

    <html:hidden property="news.id" value="${news.id}"/>

    <table border="0">

        <div style="padding:1px">

            <tr>
                <td>
                    <div style="float:left;padding-right:8px;">
                        <bean:message key="add.news.label.title"/>
                    </div>
                </td>
                <td>
                    <html:text property="news.title" size="100" maxlength="1000"/>
                </td>
            </tr>
        </div>

        <div style="padding:1px">
            <tr>
                <td>
                    <div style="float:left;padding-right:8px;">
                        <bean:message key="add.news.label.date"/>
                    </div>
                </td>
                <td>
                    <logic:empty name="news">
                        <input type="text" readonly value="<fmt:formatDate type="date" value="${now}"/>" size="10"
                            maxlength="10"/>
                        <html:hidden property="news.newDate" value="${now}"/>
                    </logic:empty>

                    <logic:notEmpty name="news">
                        <input type="text" readonly value="<fmt:formatDate type="date" value="${news.date}"/>" size="10"
                               maxlength="10"/>
                        <html:hidden property="news.newDate" value="${news.date}"/>
                    </logic:notEmpty>
                </td>
            </tr>
        </div>

        <div style="padding:1px">
            <tr>
                <td>
                    <div style="float:left;padding-right:8px;">
                        <bean:message key="add.news.label.brief"/>
                    </div>
                </td>
                <td>
                    <html:textarea property="news.brief"/>
                </td>
            </tr>
        </div>

        <div style="padding:1px">
            <tr>
                <td>
                    <div style="float:left;padding-right:8px;">
                        <bean:message key="add.news.label.content"/>
                    </div>
                </td>
                <td>
                    <html:textarea property="news.content"/>
                </td>
            </tr>
        </div>

    </table>

    <div style="padding:1px">
        <div style="float:left;padding-right:8px;">
            <html:submit property="method">
                <bean:message key="add.news.button.submit"/>
            </html:submit>
            <html:cancel>
                <bean:message key="add.news.button.cancel"/>
            </html:cancel>
        </div>


    </html:form>




</div>
</body>
</html>