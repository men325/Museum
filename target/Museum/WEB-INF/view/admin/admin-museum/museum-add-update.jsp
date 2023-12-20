<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h2 align="center">Museum addition</h2>

<table class="styleForTable">
    <tr>
        <th>Назва</th>
        <th>Час відкриття</th>
        <th>Час закриття</th>
        <th>Локація</th>
        <th>Картинка</th>
    </tr>

    <tr>
        <form:form action="saveMuseum" modelAttribute="museum">

            <form:hidden path="museum_id"/>
            <form:hidden path="base64Image"/>

            <td>
                <form:input path="museum_name"/>
                <form:errors path="museum_name"/>
            </td>

            <td>
                <form:input type="time" path="museum_openTime"/>
                <form:errors path="museum_openTime"/>
            </td>

            <td>
                <form:input type="time" path="museum_closeTime"/>
                <form:errors path="museum_closeTime"/>
            </td>

            <td>
                <form:input path="museum_City"/>
                <form:errors path="museum_City"/>
            </td>

            <td>
                <c:if test="${museum.base64Image.length()>0}">
                    <img src="<c:url value='/resources/img/${museum.base64Image}'/>" width="60px"
                         alt="Error"
                         id="pic" class="zoom">
                </c:if>
                <form method="post" enctype="multipart/form-data">
                    <input type="file" name="file"><br>
                    <input type="hidden" name="image_museum"><br>
                    <input type="submit" value="Зберегти"/>
                </form>

            </td>

        </form:form>

    </tr>


</table>
<br>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>

</body>


</html>