 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=login">
        <fieldset>

            <!-- Form Name -->
            <legend>Вход в систему</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="TestLogin" type="text" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>


            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="12345" type="password" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signupbutton"></label>
                <div class="col-md-4">
                    <button id="signupbutton" name="signupbutton" class="btn btn-success">Войти</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

