<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <div class="page-header">
        <h1>Все объявления</h1>
        <p class="lead">Пример макета для вывода данных в виде таблицы</p>
    </div>

    <div class="row">
        <div class="col-md-1">Цель</div>
        <div class="col-md-3">Транспорт</div>
        <div class="col-md-4">Страна</div>
        <div class="col-md-1">Город</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-1">Дни</div>


    </div>

    <c:forEach items="${tours}" var="tour">
        <div class="row">
            <div class="col-md-1">${tour.target} </div>
            <div class="col-md-3">${tour.transport} </div>
            <div class="col-md-4">${tour.country} </div>
            <div class="col-md-1">${tour.city} </div>
            <div class="col-md-1">${tour.price} </div>
            <div class="col-md-1">${tour.days} </div>
           >
        </div>
    </c:forEach>

    <br><br>
</div>
</body>
</html>
