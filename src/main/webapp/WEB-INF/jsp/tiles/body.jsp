<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div id="body">
    <br>
    <div align="center"><h2>Breaking News</h2></div>
    <hr>
    <br>
    <logic:iterate name="newsList" id="newsListId">

        <h4><bean:write name="newsListId" property="title"/></h4>
        <bean:write name="newsListId" property="date" format="dd-MM-yyyy"/> <br>
        <bean:write name="newsListId" property="brief"/> <br>

    </logic:iterate>

</div>
</body>
</html>
