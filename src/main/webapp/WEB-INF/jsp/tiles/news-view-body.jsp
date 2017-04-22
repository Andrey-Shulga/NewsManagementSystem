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
    <html:form action="/NewsViewAction" >

        <html:hidden property="news.id"/>
        <html:hidden property="news.title"/>
        <html:hidden property="news.strDate"/>
        <html:hidden property="news.brief"/>
        <html:hidden property="news.content"/>

        <html:submit property="method">
            <bean:message key="news.view.button.edit"/>
        </html:submit>
        <html:submit property="method" onclick="return deleteForm()">
            <bean:message key="news.view.button.delete"/>
        </html:submit>
    </html:form>

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