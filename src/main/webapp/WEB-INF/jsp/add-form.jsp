<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/WEB-INF/jsp/tiles/baseLayout.jsp" flush="true">
    <tiles:put name="title" value="Add News"/>
    <tiles:put name="header" value="/WEB-INF/jsp/tiles/header.jsp"/>
    <tiles:put name="menu" value="/WEB-INF/jsp/tiles/menu.jsp"/>
    <tiles:put name="body" value="/WEB-INF/jsp/tiles/add-form-body.jsp"/>
    <tiles:put name="footer" value="/WEB-INF/jsp/tiles/footer.jsp"/>
</tiles:insert>
