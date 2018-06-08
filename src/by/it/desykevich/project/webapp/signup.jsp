<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
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
  <input id="login" name="login"  value ="TestLogintype" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите ваш login</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">Введите ваш пароль(минимум 6 символов)</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email"  value="Test E-mail" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите ваш E-mail</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nickname">Ваш ник</label>
  <div class="col-md-4">
  <input id="nickname" name="nickname" type="text" placeholder="Testnickname" class="form-control input-md" required="">
  <span class="help-block">Введите ваш ник</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phonenumber">Номер телефона</label>
  <div class="col-md-4">
  <input id="phonenumber" name="phonenumber" type="text" placeholder="+37573218194" class="form-control input-md" required="">
  <span class="help-block">Введите ваш номер телефона</span>
  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Зарегистрироваться</button>
  </div>
</div>



</fieldset>
</form>

</div class="container">
</body>
</html>




