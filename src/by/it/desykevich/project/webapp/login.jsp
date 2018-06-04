<html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=SignUp">
<fieldset>

<!-- Form Name -->
<legend>Авторизация пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login"  value ="TestLogintype"text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите ваш login</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
  <input id="password" name="password"  value="TestPassword"type="password" placeholder="" class="form-control input-md" required="">
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
</div class="container">
</body>
</html>

