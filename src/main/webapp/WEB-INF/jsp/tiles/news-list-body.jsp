<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="body">
    <br>
    <div align="center"><h2><bean:message key="body.head.news"/></h2></div>
    <hr>
    <br>

    <logic:iterate name="newsList" id="newsListId">


        <div>
            <table border="3" width="70%">
                <tr><td>
            <h4><bean:write name="newsListId" property="title"/></h4>
            <small><ins> <bean:write name="newsListId" property="date" format="dd-MM-yyyy"/> </ins></small><br><br>
            <bean:write name="newsListId" property="brief"/> <br>
                </td> </tr>

            </table>
            <table border="0">
                <tr><td>
            <html:link  action="/NewsView?id=${newsListId.id}"><bean:message key="news.list.view"/></html:link>&emsp;
                </td>
                <td>
            <html:link action="/AddNewsForm?id=${newsListId.id}"><bean:message key="news.list.edit"/></html:link>
                </td> </tr>
            </table>
            <br>
            <br>
        </div>
    </logic:iterate>

</div>
</body>
</html>
