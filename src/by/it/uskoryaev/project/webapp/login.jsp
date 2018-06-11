<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method = "post" action="do?command=login" >
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" value = "dd@mail.ru" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">write nickName</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" value = "12345" name="password" type="text" placeholder="" class="form-control input-md" required="">
    <span class="help-block">write Password</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
    <button id="Login" name="Login" class="btn btn-primary">Login</button>
  </div>
</div>

</fieldset>
</form>
</body>
</html>