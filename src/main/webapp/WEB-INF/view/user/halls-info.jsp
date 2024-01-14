<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/halls_style.css"/>">
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
        <c:url var="showExcursionsButton" value="/user/showExcursions">
            <c:param name="museumId" value="${museum_Id}"/>
        </c:url>
        <li><a href="${showExcursionsButton}">Excursions</a></li>
        <li><a href="#">Halls</a></li>
        <li><a href="#foot">Contacts</a></li>
    </ul>
</header>
<div style="height: 100%">
    <div class="flex_container main">
        <c:forEach var="hall" items="${hallList}">
            <article>
                <section>
                    <header><u>Hall №${hall.hall_id}</u></header>
                    <hr>
                    <p><u><strong>Theme:</strong></u> ${hall.hall_theme}</p>
                    <p><u><strong>Number of exhibits:</strong></u> ${hall.hall_number_of_showpieces}</p>
                    <c:set var="showpieces" value="${hall.showpieceList}"/>
                    <c:if test="${hall.hall_number_of_showpieces ne 0}">
                        <header style="font-size: 12pt;">Some exhibits in hall</header>
                        <hr>
                        <div class="exhibits">
                            <section>
                                <p><strong>Name: </strong><i>${showpieces.get(0).showpiece_name}</i></p>
                                <p><strong>Description: </strong><i>${showpieces.get(0).showpiece_description}</i></p>
                                <p><strong>Date of creation: </strong><i>${showpieces.get(0).showpiece_date_of_creation}</i></p>
                            </section>

                            <c:if test="${showpieces.size() > 1}">
                                <hr class="hr1">
                                <section>
                                    <p><strong>Name: </strong><i>${showpieces.get(1).showpiece_name}</i></p>
                                    <p><strong>Description: </strong><i>${showpieces.get(1).showpiece_description}</i></p>
                                    <p><strong>Date of creation: </strong><i>${showpieces.get(1).showpiece_date_of_creation}</i></p>
                                </section>
                            </c:if>
                        </div>
                    </c:if>
                </section>
            </article>
        </c:forEach>
    </div>
</div>

<footer id="foot">
<h3>Connect with us</h3>
<span><a href="#"><img src="<c:url value="/resources/css/facebook.png"/>" alt="facebook"></a></span>
<span><a href="#"><img src="<c:url value="/resources/css/twitter.png"/>" alt="twitter"></a></span>
<span><a href="#"><img src="<c:url value="/resources/css/instagram.png"/>" alt="instagram"></a></span>
<span><a href="https://www.youtube.com/@britishmuseum"><img src="<c:url value="/resources/css/youtube.png"/>" alt="youtube"></a></span>
<span><a href="#"><img src="<c:url value="/resources/css/message.png"/>" alt="message"></a></span>
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