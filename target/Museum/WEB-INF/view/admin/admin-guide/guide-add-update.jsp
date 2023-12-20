<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
    <title>Title</title>
</head>
<body>

<h2 align="center">Guide information</h2>

<table class="styleForTable">
    <tr>
        <th>Повне ім'я</th>
        <th>Освіта</th>
        <th>Телефон</th>
        <th>Посада</th>
        <th>Дія</th>
    </tr>

    <tr>
        <form:form action="saveGuide" modelAttribute="guide">
            <form:hidden path="guide_id"/>
            <form:hidden path="museum.museum_id" value="${museumId}"/>
            <td>
                <form:input path="guide_full_name"/>
                <form:errors path="guide_full_name"/>
            </td>
            <td>
                <form:input path="guide_education"/>
                <form:errors path="guide_education"/>
            </td>
            <td>
                <form:input type="tel" class="phone" placeholder="01234567890" path="guide_phone_number"/>
                <form:errors type="tel" class="phone" placeholder="01234567890" path="guide_phone_number"/>
            </td>
            <td>
                <form:input path="guide_post"/>
                <form:errors path="guide_post"/>
            </td>
            <td><input type="submit" value="Submit"/></td>
        </form:form>
    </tr>

</table>
<br>

<input type="button" id="buttonBack" value="Назад"
       onclick="window.location.href='/Museum/admin/showGuides?museumId=${museumId}'"/>
<input type="button" id="buttonBack2" value="У головне меню"
       onclick="window.location.href='/Museum/admin/'"/>

</body>
<script type="text/javascript">
    jQuery(function ($) {
        $(".phone").mask("+38(999)999-9999");
    });
</script>

</html>