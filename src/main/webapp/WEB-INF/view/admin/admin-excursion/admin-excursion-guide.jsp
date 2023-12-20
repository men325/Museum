<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування гідами</title>
</head>
<body>
<h2 align="center">Excursion guide information</h2>

<table class="styleForTable">
    <tr>
        <th>Повне ім'я</th>
        <th>Освіта</th>
        <th>Телефонний номер</th>
        <th>Посада</th>
        <th>Дії</th>
    </tr>

    <tr>
        <form:form action="saveGuide" modelAttribute="guide">
            <form:hidden path="guide_id"/>
            <form:hidden path="museum.museum_id" value="${museumID}"/>
            <td><form:input path="guide_full_name"/></td>
            <td><form:input path="guide_education"/></td>
            <td><form:input type="phone" path="guide_phone_number"/></td>
            <td><form:input path="guide_post"/></td>
            <td><input type="submit" value="Зберегти"/></td>
        </form:form>
    </tr>

</table>

<br>
<%--<input type="button" id="buttonAdd" value="Додати екскурсовода" onclick="window.location.href='${addNewGuideButton}'"/>--%>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>

</body>
</html>
