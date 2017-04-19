<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" ignore="true"/></title>
    <style>
        body {
            font: 11pt Arial, Helvetica, sans-serif; /* Рубленый шрифт текста */
            margin: 0; /* Отступы на странице */
        }

        h1 {
            font-size: 36px; /* Размер шрифта */
            margin: 0; /* Убираем отступы */
            color: #fc6; /* Цвет текста */
        }

        h2 {
            margin-top: 0; /* Убираем отступ сверху */
        }

        #header { /* Верхний блок */
            background: #0080c0; /* Цвет фона */
            padding: 10px; /* Поля вокруг текста */
            text-align: center;
        }

        #menu { /* Левая колонка */
            float: left; /* Обтекание справа */
            border: 1px solid #333; /* Параметры рамки вокруг */
            width: 10%; /* Ширина колонки */
            padding: 5px; /* Поля вокруг текста */
            margin: 10px 10px 20px 5px; /* Значения отступов */
        }

        #content { /* Правая колонка */
            margin: 10px 5px 20px 12%; /* Значения отступов */
            padding: 5px; /* Поля вокруг текста */
            border: 1px solid #333; /* Параметры рамки */
        }

        #footer { /* Нижний блок */
            background: #333; /* Цвет фона */
            padding: 5px; /* Поля вокруг текста */
            color: #fff; /* Цвет текста */
            clear: left; /* Отменяем действие float */
            text-align: center;
        }

        #errorcolortext {
            color: #ff070e; /* Цвет текста */
        }
    </style>
</head>

<body>


            <tiles:insert attribute="header" ignore="true"/>


            <tiles:insert attribute="menu"/>


            <tiles:insert attribute="body"/>



            <tiles:insert attribute="footer"/>


</body>
</html>