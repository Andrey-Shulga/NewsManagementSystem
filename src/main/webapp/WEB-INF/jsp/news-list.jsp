<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tiles:insert page="/WEB-INF/jsp/tiles/baseLayout.jsp" flush="true">
    <tiles:put name="title" value="News List"/>
    <tiles:put name="header" value="/WEB-INF/jsp/tiles/header.jsp"/>
    <tiles:put name="menu" value="/WEB-INF/jsp/tiles/menu.jsp"/>
    <tiles:put name="body" value="/WEB-INF/jsp/tiles/news-list-body.jsp"/>
    <tiles:put name="footer" value="/WEB-INF/jsp/tiles/footer.jsp"/>
</tiles:insert>
