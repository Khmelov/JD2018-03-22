<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
 <p>People:<br> ${people}</p>
    <p>All tours of people:<br> ${listToursPeople}</p>
<form class="form-horizontal" method="post" action"do?command=Profile">
<fieldset>

<!-- Form Name -->
<legend>Logout</legend>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" value="LogoutTrue" class="btn btn-primary">Button</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
