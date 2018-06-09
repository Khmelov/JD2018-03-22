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
        <div class="col-md-1">Цена</div>
        <div class="col-md-3">Адрес</div>
        <div class="col-md-4">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>

    </div>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-1">${ad.price} </div>
            <div class="col-md-3">${ad.address} </div>
            <div class="col-md-4">${ad.description} </div>
            <div class="col-md-1">${ad.rooms} </div>
            <div class="col-md-1">${ad.area} </div>
            <div class="col-md-1">${ad.flat} </div>
            <div class="col-md-1">${ad.flats} </div>
        </div>
    </c:forEach>

    <br><br>
</div>
</body>
</html>
