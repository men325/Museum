<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <title>Title</title>
</head>
<body>
<h2 align="center">Excursion addition</h2>

<table class="styleForTable">
    <tr>
        <th>Назва</th>
        <th>Опис</th>
        <th>Дата</th>
        <th>Початок</th>
        <th>Кінець</th>
        <th>Прохідний вік</th>
        <th>Ціна</th>
        <th>Гіди</th>
        <th>Зали</th>
        <th></th>
    </tr>

    <tr>
        <form:form action="saveExcursion" modelAttribute="excursion">
            <form:hidden path="id_excursion"/>
            <form:hidden path="museum.museum_id" value="${museumToShow}"/>
            <form:hidden path="guide.museum.museum_id" value="${museumToShow}"/>
            <td>
                <form:input path="excursion_name"/>
            </td>

            <td>
                <form:input path="excursion_description"/>
            </td>

            <td>
                <form:input type="date" path="excursion_date"/>
            </td>

            <td>
                <form:input type="time" path="excursion_start_time"/>
            </td>

            <td>
                <form:input type="time" path="excursion_end_time"/>
            </td>

            <td>
                <form:input path="excursion_age_access"/>
            </td>

            <td>
                <form:input path="excursion_price"/>
            </td>

            <td>

                <form:select path="guide.guide_id">
                    <%--                    <form:option value="${museumToShow.museum_id}">${museumToShow.museum_name}</form:option>--%>
                    <form:options items="${fullGuideList}" itemValue="guide_id" itemLabel="guide_full_name"/>

                </form:select>

            </td>

            <td>
                <form>

                    <div class="multiselect">

                        <div class="selectBox" onclick="showCheckboxes()">
                            <select>

                                <option>Виберіть зали</option>
                            </select>
                            <div class="overSelect"></div>
                        </div>
                        <div id="checkboxes">

                            <form:checkboxes path="hallList" items="${fullHallsListInMuseum}"/>

                        </div>

                    </div>
                    <input type="submit" value="Додати"/>
                </form>
            </td>


            <%--            <p><form:button type="submit" id="saveExcursion" value="Додати"/></p>--%>

        </form:form>

    </tr>

</table>

</body>

<br>
<input type="button" id="buttonBack" value="У головне меню" onclick="window.location.href='/Museum/admin/'"/>


<script>
    var expanded = false;

    function showCheckboxes() {
        var checkboxes = document.getElementById("checkboxes");
        if (!expanded) {
            checkboxes.style.display = "block";
            expanded = true;
        } else {
            checkboxes.style.display = "none";
            expanded = false;
        }
    }
</script>

</html>