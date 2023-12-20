<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Керування користувачами</title>
</head>
<body>
<h2 align="center">Users information</h2>

<table class="styleForTable">
    <tr>
        <th>Повне ім'я</th>
        <th>Вік користувача</th>
        <th>Телефон</th>
        <th>Пошта</th>
        <th>Дія</th>
    </tr>

    <c:forEach var="user" items="${userList}">


        <c:url var="addNewUserButton" value="addNewUser">
            <c:param name="excursionId" value="${excursionID}"/>
        </c:url>
        <c:url var="updateUserButton" value="updateUser">
            <c:param name="userId" value="${user.user_id}"/>
            <c:param name="excursionId" value="${excursionID}"/>
        </c:url>
        <c:url var="SendMailButton" value="sendMailToUser">
            <c:param name="userId" value="${user.user_id}"/>
            <c:param name="excursionId" value="${excursionID}"/>
        </c:url>
        <c:url var="deleteUserButton" value="deleteUser">
            <c:param name="userId" value="${user.user_id}"/>
            <c:param name="excursionId" value="${excursionID}"/>
        </c:url>

        <tr>
            <td>${user.user_full_name}</td>
            <td>${user.user_age}</td>
            <td>${user.user_phone}</td>
            <td>${user.user_email}</td>
            <td>
                <input type="button" value="Змінити дані" onclick="window.location.href='${updateUserButton}'">
                <input type="button" value="Видалити дані" onclick="window.location.href='${deleteUserButton}'">
                <input type="button" value="Відправити повторне запрошення"
                       onclick="window.location.href='${SendMailButton}'">
            </td>
        </tr>


    </c:forEach>

</table>

<br>
<input type="button" id="buttonAdd" value="Додати користувача" onclick="window.location.href='${addNewUserButton}'"/>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>
</body>
</html>
