<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
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
            </table><br>
        </div>
    </logic:iterate>

</div>
</body>
</html>
