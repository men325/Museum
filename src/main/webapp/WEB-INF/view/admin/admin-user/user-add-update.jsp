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
<h2 align="center">Users addition</h2>

<table class="styleForTable">
    <tr>
        <th>Повне ім'я</th>
        <th>Вік користувача</th>
        <th>Телефон</th>
        <th>Пошта</th>
        <th></th>
    </tr>

    <tr>
        <form:form action="saveUser" modelAttribute="user">
            <form:hidden path="user_id"/>
            <form:hidden path="excursion.id_excursion" value="${excursionID}"/>
            <td>
                <form:input path="user_full_name"/>
                <form:errors path="user_full_name"/>
            </td>
            <td>
                <form:input path="user_age"/>
            </td>
            <td>
                <form:input type="tel" class="phone" placeholder="01234567890" path="user_phone"/>
                <form:errors type="tel" class="phone" placeholder="01234567890" path="user_phone"/>
            </td>
            <td>
                <form:input type="email" path="user_email" placeholder="yourmail@ukr.net"/>
                <form:errors type="email" path="user_email" placeholder="yourmail@ukr.net"/>
            </td>
            <td><input type="submit" value="Зберегти"/></td>
        </form:form>
    </tr>

</table>
<br>
<%--<input type="button" id="buttonBack" value="Назад"--%>
<%--       onclick="window.location.href='/Museum/admin/showGuides?museumId=${museumId}'"/>--%>
<%--<input type="button" id="buttonBack2" value="У головне меню"--%>
<%--       onclick="window.location.href='/Museum/admin/'"/>--%>

</body>

<script type="text/javascript">
    jQuery(function ($) {
        $(".phone").mask("+38(999)999-9999");
    });
</script>


</html>