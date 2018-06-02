<html>
<%@ include file="include/head.htm" %>
<body>
<%@ include file="include/menu.htm" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Sing Up</legend>

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
  <label class="col-md-4 control-label" for="Sing Up">Sing Up</label>
  <div class="col-md-4">
    <button id="Sing Up" name="Sing Up" class="btn btn-primary">Sing Up</button>
  </div>
</div>

</fieldset>
</form>

</body>
</html>




