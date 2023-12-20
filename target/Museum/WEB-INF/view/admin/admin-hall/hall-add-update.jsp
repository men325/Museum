<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h2 align="center">Hall addition</h2>


<table class="styleForTable">
    <tr>
        <th>Тематика</th>
        <th>Кількість експонатів</th>
        <th>Доступ</th>
        <th>Музей</th>
        <th></th>
    </tr>
    <tr>
        <form:form action="saveHall" modelAttribute="hall">

            <form:hidden path="hall_id"/>
            <form:hidden path="excursion.id_excursion"/>

            <td>
                <form:input path="hall_theme"/>
                <form:errors path="hall_theme"/>
            </td>
            <td>
                <form:input readonly="true" path="hall_number_of_showpieces"/>
            </td>
            <td>
                <form:select path="hall_access">
                    <form:option value="1">Є доступ</form:option>
                    <form:option value="0">Немає доступу</form:option>

                </form:select>
            </td>

            <td>
                <form:select path="museum.museum_id">
                    <form:option value="${museumToShow.museum_id}">${museumToShow.museum_name}</form:option>
                    <form:options items="${museumList}" itemValue="museum_id" itemLabel="museum_name"/>
                </form:select>
            </td>
            <td><input type="submit" value="Зберегти"/></td>

        </form:form>
    </tr>


</table>

<br>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>


</body>
</html>
