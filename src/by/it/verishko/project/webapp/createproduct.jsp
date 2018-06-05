<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=createproduct">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" value="Valera" placeholder="name" class="form-control input-md">
  <span class="help-block">Input product name</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="description">description</label>
  <div class="col-md-4">
  <input id="description" name="description" type="text" value="Neighbour" placeholder="description" class="form-control input-md">
  <span class="help-block">Input product description</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" value="66" placeholder="price" class="form-control input-md">
  <span class="help-block">Input product price</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Create</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>