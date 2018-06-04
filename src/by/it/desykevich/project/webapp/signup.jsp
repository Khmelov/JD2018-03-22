<html>
<%@ include file="include/head.htm" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=SignUp">
<fieldset>

<!-- Form Name -->
<legend>Регистрация пользователя</legend>

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
  <input id="password" name="password"  value="TestPassword"type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">symbols: a-zA-Z0-9 </span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
    <input id="email" name="email" value="Test E-mail" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">your email</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Registration</button>
  </div>
</div>

</fieldset>
</form>

</div class="container">
</body>
</html>




