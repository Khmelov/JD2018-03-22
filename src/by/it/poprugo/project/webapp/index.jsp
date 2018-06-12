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
            <div class="col-md-2">Модель</div>
            <div class="col-md-1">Имя Заказчика</div>
            <div class="col-md-2">Телефон</div>
            <div class="col-md-2">Номер контракта</div>
            <!-- <div class="col-md-1">Дата контракта</div> -->
            <div class="col-md-1">Аванс</div>

        </div>

        <c:forEach items="${ads}" var="ad">
            <div class="row">
                <div class="col-md-1">${ad.price} </div>
                <div class="col-md-3">${ad.address} </div>
                <div class="col-md-2">${ad.model} </div>
                <div class="col-md-1">${ad.name} </div>
                <div class="col-md-2">${ad.phone} </div>
                <div class="col-md-2">${ad.number} </div>
                <!-- <div class="col-md-1">${ad.datacontr} </div> -->
                <div class="col-md-1">${ad.keymoney} </div>
            </div>
    </c:forEach>

    <br><br>
</div>
</body>
</html>
