<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування залами</title>
</head>
<body>
<h2 align="center">Halls information</h2>

<table class="styleForTable">
    <tr>
        <th>Тематика</th>
        <th>Кількість єкспонатів</th>
        <th>Доступ</th>
        <th>Дії</th>
        <th>Експонати залу</th>
    </tr>

    <c:forEach var="hall" items="${hallList}">

        <c:url var="showShowpiecesButton" value="showShowpieces">
            <c:param name="hallId" value="${hall.hall_id}"/>
        </c:url>
        <c:url var="addNewHall" value="addNewHall">
            <c:param name="museumId" value="${museumID}"/>
        </c:url>
        <c:url var="updateHallButton" value="updateHall">
            <c:param name="hallId" value="${hall.hall_id}"/>
            <c:param name="hMuseumId" value="${museumID}"/>
            <c:param name="hExcursionId" value="${hall.excursion.id_excursion}"/>
        </c:url>
        <c:url var="deleteHallButton" value="deleteHall">
            <c:param name="hallId" value="${hall.hall_id}"/>
            <c:param name="hMuseumId" value="${museumID}"/>
        </c:url>

        <tr>
            <td>${hall.hall_theme}</td>
            <td>${hall.hall_number_of_showpieces}</td>
            <td>${hall.hall_access}</td>
            <td>
                <input type="button" value="Змінити дані" onclick="window.location.href='${updateHallButton}'">
                <input type="button" value="Видалити дані" onclick="window.location.href='${deleteHallButton}'">
            </td>

            <td>
                <input type="button" value="Експонати" onclick="window.location.href='${showShowpiecesButton}'">
            </td>
        </tr>


    </c:forEach>

</table>

<br>
<input type="button" id="buttonAdd" value="Додати зал" onclick="window.location.href='${addNewHall}'"/>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>
</body>
</html>
