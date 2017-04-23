<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div id="body">

    <html:errors/>
    <html:form action="/AddNews">

        <html:hidden  property="news.id"/>

    <table border="0">

        <div style="padding:1px">

            <tr>
                <td>
                    <div style="float:left;padding-right:8px;">
                        <bean:message key="add.news.label.title"/>
                    </div>
                </td>
                <td>
                    <html:text  property="news.title"  size="100" maxlength="1000"/>
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
                    <html:text readonly="true" property="news.strDate" />
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
                    <html:textarea  property="news.brief" />
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
                    <html:textarea  property="news.content" />
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