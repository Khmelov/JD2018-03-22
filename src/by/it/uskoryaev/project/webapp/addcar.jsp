<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal"  method="post" action="do?command=AddCar">
    <fieldset>

    <!-- Form Name -->
    <legend>Add Car</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="SerialNumber">SerialNumber</label>
      <div class="col-md-4">
      <input id="SerialNumber" name="SerialNumber" type="text" value = "er7er7r" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Brand">Brand</label>
      <div class="col-md-4">
        <input id="Brand" name="Brand" type="text" value = "Mercedes" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Model">Model</label>
      <div class="col-md-4">
      <input id="Model" name="Model"  value = "S-class" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Color">Color</label>
      <div class="col-md-4">
      <input id="Color" name="Color" value = "black" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="BodyCar">BodyCar</label>
      <div class="col-md-4">
      <input id="BodyCar" name="BodyCar" value = "coupe" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="YearRelease">YearRelease</label>
      <div class="col-md-4">
      <input id="YearRelease" name="YearRelease" value = "11/12/2017" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Save">Save</label>
      <div class="col-md-4">
        <button id="Save" name="Save" class="btn btn-primary">Save</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>

