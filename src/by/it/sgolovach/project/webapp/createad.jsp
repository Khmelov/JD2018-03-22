<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menulog.htm" %>
<form class="form-horizontal" method="post" action="do?command=createad">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">description</label>
  <div class="col-md-4">
  <input id="description" name="description" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">description</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="rooms">rooms</label>
  <div class="col-md-4">
  <input id="rooms" name="rooms" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">rooms</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">price</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="area">area</label>
  <div class="col-md-4">
  <input id="area" name="area" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">area</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="flat">flat</label>
  <div class="col-md-4">
  <input id="flat" name="flat" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">flat</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="flats">flats</label>
  <div class="col-md-4">
  <input id="flats" name="flats" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">flats</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="adress">adress</label>
  <div class="col-md-4">
  <input id="adress" name="adress" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">adress</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create">creat</label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">create</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>