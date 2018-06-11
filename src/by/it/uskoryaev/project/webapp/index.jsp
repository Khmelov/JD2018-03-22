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
        <div class="col-md-2">SerialNumber</div>
        <div class="col-md-2">Brand</div>
        <div class="col-md-2">Model</div>
        <div class="col-md-2">BodyCar</div>
        <div class="col-md-2">Color</div>
        <div class="col-md-2">YearRelease</div>

    </div>

    <c:forEach items="${chooseCar}" var="car">
        <div class="row">
            <div class="col-md-2">${car.SerialNumber} </div>
            <div class="col-md-2">${car.Brand} </div>
            <div class="col-md-2">${car.Model} </div>
            <div class="col-md-2">${car.BodyCar} </div>
            <div class="col-md-2">${car.Color} </div>
            <div class="col-md-2">${car.YearRelease} </div>
        </div>
    </c:forEach>

    <br><br>
</div>
</body>
</html>
