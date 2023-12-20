<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування гідами</title>
</head>
<body>

<h2 align="center">Guide information</h2>

<table class="styleForTable">
    <tr>
        <th>Повне ім'я</th>
        <th>Освіта</th>
        <th>Телефонний номер</th>
        <th>Посада</th>
        <th>Дії</th>
    </tr>

    <c:forEach var="guide" items="${guideList}">

        <c:url var="addNewGuideButton" value="addNewGuide">
            <c:param name="guideId" value="${guide.guide_id}"/>
            <c:param name="museumId" value="${guide.museum.museum_id}"/>
        </c:url>
        <c:url var="updateGuideButton" value="updateGuide">
            <c:param name="guideId" value="${guide.guide_id}"/>
            <c:param name="museumId" value="${guide.museum.museum_id}"/>
        </c:url>
        <c:url var="deleteGuideButton" value="deleteGuide">
            <c:param name="guideId" value="${guide.guide_id}"/>
            <c:param name="museumId" value="${guide.museum.museum_id}"/>
        </c:url>


        <tr>
            <td>${guide.guide_full_name}</td>
            <td>${guide.guide_education}</td>
            <td>${guide.guide_phone_number}</td>
            <td>${guide.guide_post}</td>

            <td>
                <input type="button" value="Змінити дані" onclick="window.location.href='${updateGuideButton}'">
                <input type="button" value="Видалити дані" onclick="window.location.href='${deleteGuideButton}'">
            </td>
        </tr>


    </c:forEach>

</table>

<br>
<input type="button" id="buttonAdd" value="Додати екскурсовода" onclick="window.location.href='${addNewGuideButton}'"/>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>

</body>
</html>
