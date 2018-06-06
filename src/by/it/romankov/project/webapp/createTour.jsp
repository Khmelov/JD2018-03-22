<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=createtour">
<fieldset>

<!-- Form Name -->
<legend>Добавление тура</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Target</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" value="shopping" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Transport</label>
  <div class="col-md-4">
  <input id="" name="" value="bus" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Country</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" value="Poland" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">City</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" value="Warsawa" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Price</label>
  <div class="col-md-2">
  <input id="textinput" name="textinput" value="105" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Days</label>
  <div class="col-md-2">
  <input id="textinput" name="textinput" value="3" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Добавить тур</button>
  </div>
</div>

</fieldset>
</form>


</div>
</body>
</html>
