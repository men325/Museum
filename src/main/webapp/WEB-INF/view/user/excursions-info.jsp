<%--
  Created by IntelliJ IDEA.
  User: holeg
  Date: 25.01.2023
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/excursion_style.css"/>">
  <link rel="shortcut icon" href="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" type="image/x-icon">
  <title>Excursion</title>
</head>

<body>
<header>
  <ul class="menu">
    <li><img src="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" alt="Travel bus" class="logo"></li>
    <c:url var="main" value="/user/"/>
    <li><a href="${main}">Main page</a></li>
    <c:url var="museums" value="/user/allMuseums"/>
    <li><a href="${museums}">Museums</a></li>
    <li><a href="#">Excursions</a></li>
    <c:url var="showHallsButton" value="/user/showHalls">
      <c:param name="museumId" value="${museum_Id}"/>
    </c:url>
    <li><a href="${showHallsButton}">Halls</a></li>
    <li><a href="#foot">Contacts</a></li>
  </ul>
</header>

<div class="flex_container main">
  <c:forEach var="excursion" items="${excursionListForMuseum}">
    <article>
      <section>
        <header>${excursion.excursion_name}</header>
        <hr>
        <p>Date: <strong>${excursion.excursion_date}</strong></p>
        <p>Time: <strong>${excursion.excursion_start_time}</strong> - <strong>${excursion.excursion_end_time}</strong></p>
        <p>Price: <strong>${excursion.excursion_price}</strong> UAN</p>
      </section>
      <c:url var="aboutExcursion" value="aboutExcursion">
        <c:param name="excursionId" value="${excursion.id_excursion}"/>
      </c:url>
      <input type="button" class="button" value="Read more ..." onclick="window.location.href='${aboutExcursion}'">
    </article>
  </c:forEach>
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

</html>
