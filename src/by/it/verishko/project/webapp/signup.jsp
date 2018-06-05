<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=signup">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" value="TestLogin" placeholder="login" class="form-control input-md" required="">
  <span class="help-block">Input your login</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" value="Test@mail.ru" placeholder="email" class="form-control input-md" required="">
  <span class="help-block">Imput your password: a-z0-9 min 5 symbols</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" value="TestPassword" placeholder="Password" class="form-control input-md" required="">
    <span class="help-block">symbols: a-z0-9 min 5 symbols</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">SignUp</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>
