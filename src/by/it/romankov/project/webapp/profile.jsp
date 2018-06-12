<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" method="post" action"do?command=Profile">
<fieldset>

<!-- Form Name -->
<legend>Обновить профиль</legend>
 <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required=""
                           value="${people.login}">
                    <span class="help-block">Login (hint)</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password Input</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="placeholder" class="form-control input-md" required=""
                           value="${people.password}">
                    <span class="help-block">(A-z min 5 symbols)</span>
                </div>
            </div>

 <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="UpdateProfile"></label>
                <div class="col-md-4">
                    <button id="UpdateProfile" name="UpdateProfile" class="btn btn-primary">Изменить</button>
                </div>
            </div>

        </fieldset>
    </form>

<div class="page-header">
        <h1>Все объявления пользователя ${people.login}</h1>

    </div>

    <div class="row">
        <div class="col-md-2">Цель</div>
        <div class="col-md-2">Транспорт</div>
        <div class="col-md-2">Страна</div>
        <div class="col-md-2">Город</div>
        <div class="col-md-2">Цена</div>
        <div class="col-md-2">Дни</div>


    </div>

    <c:forEach items="${tours}" var="tour">
        <div class="row">
            <div class="col-md-2">${tour.target} </div>
            <div class="col-md-2">${tour.transport} </div>
            <div class="col-md-2">${tour.country} </div>
            <div class="col-md-2">${tour.city} </div>
            <div class="col-md-2">${tour.price} </div>
            <div class="col-md-2">${tour.days} </div>

        </div>
    </c:forEach>


    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Выход</legend>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Выход"></label>
  <div class="col-md-4">
    <button id="Выход" name="Выход" value="LogoutTrue" class="btn btn-primary">Выйти</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
