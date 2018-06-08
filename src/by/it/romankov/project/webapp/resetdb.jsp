<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action"do?command=resetdb">

<div class="page-header">
        <h1>Все туры нашего агентства</h1>

    </div>

    <div class="row">
        <div class="col-md-2">Цель</div>
        <div class="col-md-2">Транспорт</div>
        <div class="col-md-2">Страна</div>
        <div class="col-md-2">Город</div>
        <div class="col-md-2">Цена</div>
        <div class="col-md-2">Дни</div>


    </div>

    <c:forEach items="${listTours}" var="tour">
        <div class="row">
            <div class="col-md-2">${tour.target} </div>
            <div class="col-md-2">${tour.transport} </div>
            <div class="col-md-2">${tour.country} </div>
            <div class="col-md-2">${tour.city} </div>
            <div class="col-md-2">${tour.price} </div>
            <div class="col-md-2">${tour.days} </div>
           >
        </div>
    </c:forEach>

 <form class="form-horizontal" method="post" action="do?command=resetdb">
        <fieldset>

            <!-- Form Name -->
            <legend>Сброс базы данных</legend>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Сброс"></label>
  <div class="col-md-4">
    <button id="Сброс" name="Сброс" value="LogoutTrue" class="btn btn-primary">Сбросить</button>
  </div>
</div>


</div>
</body>
</html>
