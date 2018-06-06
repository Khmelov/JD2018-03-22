<html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<p> All ads User:<br>${listAdsUser}</p>
<form class="form-horizontal" method="post" action="do?command=Logout">
<fieldset>

<!-- Form Name -->
<legend>Выход пользователя</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" value="true" class="btn btn-outline-primary">Выход</button>
  </div>
</div>

</fieldset>
</form>
</div class="container">
</body>
</html>
