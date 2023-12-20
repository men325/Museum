<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування музеями</title>
</head>
<body>
<h2 align="center">Museum information</h2>

<table class="styleForTable">
    <tr>
        <th>Фото</th>
        <th>Назва</th>
        <th>Час відкриття</th>
        <th>Час закриття</th>
        <th>Локація</th>
        <th>Дії</th>
        <th>Детальніше</th>
    </tr>

    <c:forEach var="admin_museum" items="${adminAllMuseums}">

        <c:url var="updateMuseumButton" value="updateMuseum">
            <c:param name="museumId" value="${admin_museum.museum_id}"/>
        </c:url>

        <c:url var="deleteMuseumButton" value="deleteMuseum">
            <c:param name="museumId" value="${admin_museum.museum_id}"/>
        </c:url>

        <c:url var="showHallsButton" value="showHalls">
            <c:param name="museumId" value="${admin_museum.museum_id}"/>
        </c:url>

        <c:url var="showExcursionsButton" value="showExcursions">
            <c:param name="museumId" value="${admin_museum.museum_id}"/>
        </c:url>

        <c:url var="showGuidesButton" value="showGuides">
            <c:param name="museumId" value="${admin_museum.museum_id}"/>
        </c:url>

        <tr>
            <td>
                <c:if test="${admin_museum.base64Image.length()>0}">
                    <img src="<c:url value='/resources/img/${admin_museum.base64Image}'/>" width="80px"
                         alt="Error"
                         id="pic" class="zoom">
                </c:if>
                <c:if test="${admin_museum.base64Image.length()==null}">
                    <input type="text" value="No picture" readonly="readonly"/>
                </c:if>

            </td>

            <td>${admin_museum.museum_name}</td>
            <td>${admin_museum.museum_openTime}</td>
            <td>${admin_museum.museum_closeTime}</td>
            <td>${admin_museum.museum_City}</td>
            <td>
                <input type="button" value="Змінити дані" onclick="window.location.href='${updateMuseumButton}'">
                <input type="button" value="Видалити дані" onclick="window.location.href='${deleteMuseumButton}'">
            </td>
            <td>
                <input type="button" value="Зали музею" onclick="window.location.href='${showHallsButton}'">
                <input type="button" value="Екскурсії музею" onclick="window.location.href='${showExcursionsButton}'">
                <input type="button" value="Екскурсоводи музею" onclick="window.location.href='${showGuidesButton}'">
            </td>
        </tr>

    </c:forEach>

</table>

<br>
<input type="button" id="buttonAdd" value="Додати музей" onclick="window.location.href='addNewMuseum'"/>

</body>
</html>


