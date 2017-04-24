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

    <html:form action="/NewsListDelete">
        <html:errors/>
        <html:hidden property="news.title" value="pass_validation"/>
        <html:hidden property="news.brief" value="pass_validation"/>
        <html:hidden property="news.content" value="pass_validation"/>

        <logic:iterate name="NewsForm" property="newsList" id="news">

            <div>
                <table border="3" width="70%">
                    <tr>
                        <td>
                            <h4><bean:write name="news" property="title"/></h4>
                            <small>
                                <ins><bean:write name="news" property="date" format="dd-MM-yyyy"/></ins>
                            </small>
                            <br><br>
                            <bean:write name="news" property="brief"/> <br>
                        </td>
                    </tr>

                </table>
                <table border="0">
                    <tr>
                        <td>

                                <html:link action="/News.do?method=view&id=${news.id}">
                                    <bean:message key="news.list.view"/>
                                </html:link>&emsp;
                        </td>
                        <td>
                            <html:link action="/News.do?method=edit&id=${news.id}"><bean:message key="news.list.edit"/></html:link>
                            &emsp;&emsp;<html:multibox property="newsToDelete" value="${news.id}"/>

                        </td>
                    </tr>
                </table>

                <br>
                <br>
            </div>


        </logic:iterate>
        <logic:notEmpty name="NewsForm" property="newsList">
        <html:submit>
            <bean:message key="news.view.button.delete" />
        </html:submit>
        </logic:notEmpty>
    </html:form>

</div>
</body>
</html>
