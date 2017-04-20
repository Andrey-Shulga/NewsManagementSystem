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
    <div align="center"><h2>Breaking News</h2></div>
    <hr>
    <br>

    <logic:iterate name="newsList" id="newsListId">
        <div>
            <h4><bean:write name="newsListId" property="title"/></h4>
            <bean:write name="newsListId" property="date" format="dd-MM-yyyy"/> <br>
            <bean:write name="newsListId" property="brief"/> <br>
        </div>
    </logic:iterate>

</div>
</body>
</html>
