<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" method="POST" action="do?command=Login">
<fieldset>

<!-- Form Name -->
<legend>Авторизация пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login"  value="Test" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите ваш login</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
  <input id="password" name="password" value="Test" type="password" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите ваш пароль(минимум 6 символов)</span>
  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Войти</button>
  </div>
</div>
</fieldset>
</form>
</div>
</body>
</html>

