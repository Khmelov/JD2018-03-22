<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" value = "alex" type="text" placeholder="Login" class="form-control input-md" required="">
  <span class="help-block">write Login</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password</label>
  <div class="col-md-4">
    <input id="Password" value = "12345" name="Password" type="password" placeholder="Password" class="form-control input-md" required="">
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