<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>

<tiles:insert page="/WEB-INF/jsp/tiles/baseLayout.jsp" flush="true">
    <tiles:put name="title"><bean:message key="news.add.title"/></tiles:put>
    <tiles:put name="header" value="/WEB-INF/jsp/tiles/header.jsp"/>
    <tiles:put name="menu" value="/WEB-INF/jsp/tiles/menu.jsp"/>
    <tiles:put name="body" value="/WEB-INF/jsp/tiles/add-form-body.jsp"/>
    <tiles:put name="footer" value="/WEB-INF/jsp/tiles/footer.jsp"/>
</tiles:insert>
