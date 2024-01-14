<%--
  Created by IntelliJ IDEA.
  User: holeg
  Date: 25.01.2023
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/main_style.css"/>">
    <link rel="shortcut icon" href="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>

    <title>Excursion</title>
    <script>${error}</script>
</head>

<body>
<header>
    <ul class="menu">
        <li><img src="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" alt="Travel bus" class="logo"></li>
        <c:url var="main" value="/user/"/>
        <li><a href="${main}">Main page</a></li>
        <c:url var="museums" value="/user/allMuseums"/>
        <li><a href="${museums}">Museums</a></li>
        <c:url var="showExcursionsButton" value="/user/showExcursions">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
        </c:url>
        <li><a href="${showExcursionsButton}">Excursions</a></li>
        <c:url var="showHallsButton" value="/user/showHalls">
            <c:param name="museumId" value="${excursion.museum.museum_id}"/>
        </c:url>
        <li><a href="${showHallsButton}">Halls</a></li>
        <li><a href="#foot">Contacts</a></li>
    </ul>
</header>

<div class="flex_container main">
    <article class="flex">
        <section style="margin-right: 10%; width: 100%">
            <header>${excursion.excursion_name}</header>
            <hr>
            <p><strong>About</strong></p>
            <p>${excursion.excursion_description}</p>
            <p><strong>Date:</strong> ${excursion.excursion_date}</p>
            <p><strong>Time:</strong> ${excursion.excursion_start_time} - ${excursion.excursion_end_time}</p>
            <p><strong>Price:</strong> ${excursion.excursion_price} UAN</p>
            <p><strong>Age access:</strong> ${excursion.excursion_age_access}+</p>
            <p><strong>Your guide:</strong> ${excursion.guide.guide_full_name}, ${excursion.guide.guide_post}</p>
            <c:url var="halls" value="/user/showHallsOfExcursion">
                <c:param name="museumId" value="${excursion.museum.museum_id}"/>
                <c:param name="excursionId" value="${excursion.id_excursion}"/>
            </c:url>
            <p><strong>Halls:</strong> <a href="${halls}">
                <c:forEach var="hall" items="${excursion.hallList}">
                    ${hall.hall_id};
                </c:forEach>
            </a></p>
        </section>
        <section style="border: 1px solid;border-radius: 6px;padding: 6px; margin-bottom: 20%">
            <form:form action="saveUser" modelAttribute="user">
                <form:hidden path="user_id"/>
                <form:hidden path="excursion.id_excursion" value="${excursion.id_excursion}"/>
                <p>
                    Your fullname: <form:input path="user_full_name"/>
                    <form:errors path="user_full_name"/>
                </p>
                <p>Your age: <form:input path="user_age"/></p>
                <p>
                    Your phone number: <form:input type="tel" class="phone" placeholder="01234567890"
                                                   path="user_phone"/>
                    <form:errors type="tel" class="phone" placeholder="01234567890" path="user_phone"/>
                </p>
                <p>
                    Your email: <form:input type="email" placeholder="yourmail@ukr.net" path="user_email"/>
                    <form:errors type="email" placeholder="yourmail@ukr.net" path="user_email"/>
                </p>
                <p><input type="submit" value="Book a ticket" class="button"></p>
            </form:form>
        </section>
    </article>
</div>

<footer id="foot">
    <h3>Connect with us</h3>
    <span><a href="#"><img src="<c:url value="/resources/css/facebook.png"/>" alt="facebook"></a></span>
    <span><a href="#"><img src="<c:url value="/resources/css/twitter-icon.webp"/>" alt="twitter"></a></span>
    <span><a href="#"><img src="<c:url value="/resources/css/img.png"/>" alt="instagram"></a></span>
    <span><a href="https://www.youtube.com/@britishmuseum"><img src="<c:url value="/resources/css/img_1.png"/>" alt="youtube"></a></span>
    <span><a href="#"><img src="<c:url value="/resources/css/img_2.png"/>" alt="message"></a></span>
    <p>+380294235479</p>
    <hr>
    <div class="footer_menu">
        <a href="#">About us</a>
        <a href="#">Museums map</a>
        <a href="<c:url value="/admin/"/>">Administrator</a>
        <a href="#">Privacy police</a>
        <a href="#">Coockies</a>
        <span>@2023</span>
    </div>
</footer>
</body>

<script type="text/javascript">
    jQuery(function ($) {
        $(".phone").mask("+38(999)999-9999");
    });
</script>

</html>