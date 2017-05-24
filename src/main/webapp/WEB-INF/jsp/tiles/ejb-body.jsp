<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div id="body">
    <h3>News list from ejb server:</h3>
    <ol>
        <c:forEach items="${news}" var="news">
            <li>
                    ${news.title} <br>
                    ${news.date} <br>
                    ${news.brief}<br>

            </li>
        </c:forEach>
    </ol>


</div>
</body>
</html>