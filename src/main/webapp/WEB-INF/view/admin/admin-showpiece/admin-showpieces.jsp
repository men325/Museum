<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування експонатами</title>
</head>
<body>
<h2 align="center">Showpiece information</h2>

<table class="styleForTable">
    <tr>
        <th>Назва</th>
        <th>Опис</th>
        <th>Дата створення</th>
        <th>Дії</th>
    </tr>

    <c:forEach var="showpiece" items="${ShowpieceList}">

        <%--        <c:url var="showShowpiecesButton" value="showShowpieces">--%>
        <%--            <c:param name="hallId" value="${hall.hall_id}"/>--%>
        <%--        </c:url>--%>
        <c:url var="addNewShowpieceButton" value="addNewShowpiece">
            <c:param name="hallId" value="${hallsID}"/>
        </c:url>
        <c:url var="updateShowpieceButton" value="updateShowpiece">
            <c:param name="showpieceId" value="${showpiece.showpiece_id}"/>
            <c:param name="sHallId" value="${hallsID}"/>
        </c:url>
        <c:url var="deleteShowpieceButton" value="deleteShowpiece">
            <c:param name="showpieceId" value="${showpiece.showpiece_id}"/>
            <c:param name="hallId" value="${hallsID}"/>
        </c:url>

        <tr>
            <td>${showpiece.showpiece_name}</td>
            <td>${showpiece.showpiece_description}</td>
            <td>${showpiece.showpiece_date_of_creation}</td>
            <td>
                <input type="button" value="Змінити дані" onclick="window.location.href='${updateShowpieceButton}'">
                <input type="button" value="Видалити дані" onclick="window.location.href='${deleteShowpieceButton}'">
            </td>
        </tr>


    </c:forEach>

</table>

<br>
<input type="button" id="buttonAdd" value="Додати експонат" onclick="window.location.href='${addNewShowpieceButton}'"/>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>
</body>
</html>
