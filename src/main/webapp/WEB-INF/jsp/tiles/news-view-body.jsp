<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

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
                    <bean:write name="NewsForm" property="news.title"/>
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
                    <bean:write name="NewsForm" property="news.date" format="dd/MM/yyyy"/>
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
                    <bean:write name="NewsForm" property="news.brief"/>
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
                    <bean:write name="NewsForm" property="news.content"/>
                </td>
            </tr>
        </div>

    </table>

    <html:link action="/News?method=edit&id=${news.id}">
        <button type="button" >
            <bean:message key="news.view.button.edit"/>
        </button>
    </html:link>

    <html:link action="/News?method=delete&id=${news.id}">
        <button type="button" onclick="return deleteForm()">
            <bean:message key="news.view.button.delete"/>
        </button>
    </html:link>

    <script type="text/javascript">
        function deleteForm() {
            var answer = window.confirm("<bean:message key="confirm.news.delete.message"/>");
            if(answer) {
                return true;
            } else return false;
        }
    </script>


</div>
</body>
</html>
