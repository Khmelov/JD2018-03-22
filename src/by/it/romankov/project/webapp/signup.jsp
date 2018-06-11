<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action"do?command=signup">
<fieldset>

<!-- Form Name -->
<legend>Регистрация</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="testlogin"type="text" placeholder="placeholder" class="form-control input-md">
  <span class="help-block">input your login</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" value="testEmail" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">input your email</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="testPassword"  type="password" placeholder="" class="form-control input-md">
<span class="help-block">a-zA-Z0-9 min 5 symbols</span>  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" value="testname"type="text" placeholder="placeholder" class="form-control input-md">
  <span class="help-block">input your name</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="telephone">Telephone</label>
  <div class="col-md-4">
  <input id="telephone" name="telephone" value="1234567"type="text" placeholder="placeholder" class="form-control input-md">
  <span class="help-block">input your telephone number</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="age">Age</label>
  <div class="col-md-4">
  <input id="age" name="age" value="25"type="text" placeholder="placeholder" class="form-control input-md">
  <span class="help-block">input your age</span>
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signupbutton"></label>
  <div class="col-md-4">
    <button id="signupbutton" name="signupbutton" class="btn btn-primary">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>




