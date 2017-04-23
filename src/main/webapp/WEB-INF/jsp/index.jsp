<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>

<jsp:forward page="/News.do?method=list"/>

<tiles:insert page="/WEB-INF/jsp/tiles/baseLayout.jsp" flush="true">
    <tiles:put name="title" value="News Management"/>
    <tiles:put name="header" value="/WEB-INF/jsp/tiles/header.jsp"/>
    <tiles:put name="menu" value="/WEB-INF/jsp/tiles/menu.jsp"/>
    <tiles:put name="body" value="/WEB-INF/jsp/tiles/news-list-body.jsp"/>
    <tiles:put name="footer" value="/WEB-INF/jsp/tiles/footer.jsp"/>
</tiles:insert>
