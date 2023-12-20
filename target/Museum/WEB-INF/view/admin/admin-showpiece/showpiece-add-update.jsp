<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h2 align="center">Showpiece addition</h2>

<table class="styleForTable">
    <tr>
        <th>Назва</th>
        <th>Опис</th>
        <th>Часи створення</th>
        <th>Зал</th>
        <th>Дії</th>
    </tr>

    <tr>
        <form:form action="saveShowpiece" modelAttribute="showpiece">
            <form:hidden path="showpiece_id"/>
            <td>
                <form:input path="showpiece_name"/>
                <form:errors path="showpiece_name"/>
            </td>
            <td>
                <form:input path="showpiece_description"/>
                <form:errors path="showpiece_description"/>
            </td>
            <td>
                <form:input type="date" path="showpiece_date_of_creation"/>
                <form:errors type="date" path="showpiece_date_of_creation"/>
            </td>
            <td>
                <form:select path="hall.hall_id">
                    <form:option value="${hallToShow.hall_id}">${hallToShow.hall_theme}</form:option>
                    <form:options items="${hallList}" itemValue="hall_id" itemLabel="hall_theme"/>
                </form:select>
            </td>
            <td><input type="submit" value="Submit"/></td>
        </form:form>
    </tr>
</table>

</body>
</html>
