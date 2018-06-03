<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=logout">
<fieldset>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout">logout</label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-primary">logout</button>
  </div>
</div>
</fieldset>
</form>
</div>
</body>
</html>
