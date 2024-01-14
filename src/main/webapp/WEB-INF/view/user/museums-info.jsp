<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/museums_style.css"/>">
    <link rel="shortcut icon" href="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" type="image/x-icon">
    <title>Museums</title>
</head>

<body>
<header>
    <ul class="menu">
        <li><img src="<c:url value="https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1024px-Mercedes-Logo.svg.png"/>" alt="Travel bus" class="logo"></li>
        <c:url var="main" value="/user/"/>
        <li><a href="${main}">Main page</a></li>
        <li><a href="#">Museums</a></li>
        <li><a href="#foot">Contacts</a></li>
    </ul>
</header>

<div class="flex_container">
    <c:forEach var="museum" items="${allMuseums}">
        <c:url var="updateButton" value="#">
            <c:param name="#" value="#" />
        </c:url>
        <div>
            <article>
                <c:if test="${museum.base64Image.length()>0}">
                    <img src="<c:url value='/resources/img/${museum.base64Image}'/>" alt="Error">
                </c:if>
                <c:if test="${museum.base64Image.length()==null}">
                    <input type="text" value="No picture" readonly="readonly"/>
                </c:if>
                <section>
                    <header>${museum.museum_name}</header>
                    <hr>
                    <p>Opening hours of the museum:</p>
                    <p>from <strong>${museum.museum_openTime}</strong> to <strong>${museum.museum_closeTime}</strong></p>
                    <hr>
                    <p>Location: <strong>${museum.museum_City}</strong></p>
                </section>
                <c:url var="showExcursionsButton" value="showExcursions">
                    <c:param name="museumId" value="${museum.museum_id}"/>
                </c:url>
                <a href="${showExcursionsButton}" class="button" style="text-decoration: none;text-align: center;">Excursions available</a>
            </article>
        </div>
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
