<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal"  action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Обновить профиль</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required=""
                           value="${user.login}">
                    <span class="help-block">Login (hint)</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password Input</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="placeholder" class="form-control input-md" required=""
                           value="${user.password}">
                    <span class="help-block">(min 6 symbols)</span>
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
        <h1>Все модели пользователя ${user.login}</h1>
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

    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="LogoutTrue" class="btn btn-success">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
