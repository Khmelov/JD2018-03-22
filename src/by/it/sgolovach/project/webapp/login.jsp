<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <c:set var = "ID" scope = "session" value = "${userRole_id}"/>
<c:choose>
<c:when test="${ID==1}">
<%@ include file="include/menuAdmin.htm" %>
</c:when>
<c:when test="${ID==2}">
<%@ include file="include/menuUser.htm" %>
</c:when>
<c:otherwise>
<%@ include file="include/menu.htm" %>
</c:otherwise>
</c:choose>
<form class="form-horizontal" method="post" action="do?command=login">
<fieldset>

<!-- Form Name -->
<legend>Форма для входа</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="TestLogin" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">symbols: a-zA-z0-9 min 5 sym</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" value="testPassword" type="password" placeholder="" class="form-control input-md">
    <span class="help-block">a-zA-Z0-9 min 5 sym</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-primary">login</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

