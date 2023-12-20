<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування екскурсіями</title>
</head>
<body>

<h2 align="center">Excursion information</h2>

<table class="styleForTable">
    <tr>
        <th>Назва</th>
        <th>Опис</th>
        <th>Дата</th>
        <th>Початок</th>
        <th>Кінець</th>
        <th>Прохідний вік</th>
        <th>Ціна</th>
        <th>Дії</th>
        <th>Детальніше</th>
    </tr>

    <c:forEach var="excursion" items="${excursionListForMuseum}">

        <c:url var="showHallsButton" value="showExcursionHallsInMuseum">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
            <c:param name="excursionId" value="${excursion.id_excursion}"/>
        </c:url>
        <c:url var="showGuideButton" value="showGuideInExcusrion">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
            <c:param name="excursionId" value="${excursion.id_excursion}"/>
        </c:url>
        <c:url var="showUsersButton" value="showUsers">
            <%--<c:param name="museumId" value="${excursion.museum.museum_id}"/>--%>
            <c:param name="excursionId" value="${excursion.id_excursion}"/>
        </c:url>
        <c:url var="addNewExcursionButton" value="addNewExcursion">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
            <c:param name="excursionId" value="${excursion.id_excursion}"/>
        </c:url>
        <c:url var="updateExcursionButton" value="updateExcursion">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
            <c:param name="excursionId" value="${excursion.id_excursion}"/>
        </c:url>

        <c:url var="deleteExcursionButton" value="deleteExcursion">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
            <c:param name="excursionId" value="${excursion.id_excursion}"/>
        </c:url>

        <tr>
            <td>${excursion.excursion_name}</td>
            <td>${excursion.excursion_description}</td>
            <td>${excursion.excursion_date}</td>
            <td>${excursion.excursion_start_time}</td>
            <td>${excursion.excursion_end_time}</td>
            <td>${excursion.excursion_age_access}</td>
            <td>${excursion.excursion_price}</td>
            <td>
                <input type="button" value="Змінити дані" onclick="window.location.href='${updateExcursionButton}'">
                <input type="button" value="Видалити дані" onclick="window.location.href='${deleteExcursionButton}'">
            </td>
            <td>
                <input type="button" value="Екскурсовод" onclick="window.location.href='${showGuideButton}'">
                <input type="button" value="Відвідувачі" onclick="window.location.href='${showUsersButton}'">
                <input type="button" value="Зали" onclick="window.location.href='${showHallsButton}'">
            </td>
        </tr>


    </c:forEach>

</table>

<br>
<input type="button" id="buttonAdd" value="Додати екскурсію" onclick="window.location.href='${addNewExcursionButton}'"/>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>
</body>
</html>
