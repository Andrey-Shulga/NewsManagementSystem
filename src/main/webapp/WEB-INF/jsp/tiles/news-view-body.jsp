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


    <table border="0">

        <div style="padding:1px">

            <tr>
                <td>
                    <div style="float:left;padding-right:8px;">
                        <bean:message key="add.news.label.title"/>
                    </div>
                </td>
                <td>
                    <bean:write name="news" property="title"/>
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
                    <bean:write name="news" property="date" format="dd/MM/yyyy"/>
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
                    <bean:write name="news" property="brief"/>
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
                    <bean:write name="news" property="content"/>
                </td>
            </tr>
        </div>

    </table>


</div>
</body>
</html>
