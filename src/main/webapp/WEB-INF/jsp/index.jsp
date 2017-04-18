<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/WEB-INF/jsp/baseLayout.jsp" flush="true">
    <tiles:put name="title" value="Tiles Example"/>
    <tiles:put name="header" value="/WEB-INF/jsp/header.jsp"/>
    <tiles:put name="menu" value="/WEB-INF/jsp/menu.jsp"/>
    <tiles:put name="body" value="/WEB-INF/jsp/body.jsp"/>
    <tiles:put name="footer" value="/WEB-INF/jsp/footer.jsp"/>
</tiles:insert>
