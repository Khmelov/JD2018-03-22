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
        <legend>Все объявления пользователя ${user.login}</legend>
    </div>

    <div class="row">
            <div class="col-md-4"><h5>Название</h5></div>
            <div class="col-md-4"><h5>Описание</h5></div>
            <div class="col-md-4"><h5>Стоимость</h5></div>
    </div>

    <c:forEach items="${goods}" var="product">
        <div class="row">
            <div class="col-md-4">${product.name} </div>
            <div class="col-md-4">${product.description} </div>
            <div class="col-md-4">${product.price} </div>
        </div>
    </c:forEach>

    <form class="form-horizontal" method="post" action="do?command=profile">
        <fieldset>

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
