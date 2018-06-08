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
  <label class="col-md-4 control-label" for="Target">Target</label>
  <div class="col-md-4">
  <input id="Target" name="Target" value="shopping" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Transport">Transport</label>
  <div class="col-md-4">
  <input id="Transport" name="Transport" value="bus" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Country">Country</label>
  <div class="col-md-4">
  <input id="Country" name="Country" value="Poland" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="City">City</label>
  <div class="col-md-4">
  <input id="City" name="City" value="Warsawa" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Price">Price</label>
  <div class="col-md-2">
  <input id="Price" name="Price" value="105" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Days">Days</label>
  <div class="col-md-2">
  <input id="Days" name="Days" value="3" type="text" placeholder="" class="form-control input-md" required="">

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
