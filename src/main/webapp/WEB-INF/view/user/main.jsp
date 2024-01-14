<%--
  Created by IntelliJ IDEA.
  User: holeg
  Date: 23.01.2023
  Time: 22:13
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
  <title>Museums. Main page</title>
  <script>${message}</script>
</head>

<body>
<header>
  <ul class="menu">
    <li><img src="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" alt="Travel bus" class="logo"></li>
    <c:url var="allMuseums" value="allMuseums"/>
    <li><a href="#">Main page</a></li>
    <li><a href="${allMuseums}">Museums</a></li>
    <li><a href="#foot">Contacts</a></li>
  </ul>
</header>

<div class="flex_container main">
  <article class="flex">
    <section>
      <header>Welcome to the world of museums</header>
      <p>This platform is designed to facilitate the search and purchase of tickets for most museums. Our site
        cooperates with more than 100 museums and galleries of the world.</p>
      <p>This will help you quickly and without
        problems to plan your weekend with profit. Immerse
        yourself in the world of culture and history with us.</p>
    </section>
    <img src="https://img.mercedes-benz-kiev.com/data/main/mercedes-benz-s-class.webp" width="300px" alt="NationalArtMuseumOfUkraine">
<%--    <input type="button" class="button" value="Choose museum" onclick="window.location.href='${allMuseums}'">--%>
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

</html>
