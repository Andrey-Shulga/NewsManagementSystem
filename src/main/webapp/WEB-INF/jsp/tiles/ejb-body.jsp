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

            <table border="3" width="70%">
                <tr>
                    <td>
                        <h4> ${news.title} </h4>
                        <small>
                            <ins> ${news.date} </ins>
                        </small>
                        <br><br>
                            ${news.brief}<br>
                    </td>
                </tr>

            </table>
            <br>

        </c:forEach>
    </ol>

    <div>


    </div>
</body>
</html>