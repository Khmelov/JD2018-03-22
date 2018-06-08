 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=creatework">
<fieldset>

<!-- Form Name -->
<legend>Housing and communal services</legend>
<p>User:<br> ${user}</p>
<!-- Select Basic -->

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Kind of work</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="New kind of work" class="form-control input-md">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="category">Category</label>
  <div class="col-md-4">
    <select id="category" name="category" class="form-control">
        <option value="Electro">Electro</option>
        <option value="WaterPipes">Water pipes</option>
        <option value="Repairs">Repairs</option>
      </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="unit">Units</label>
  <div class="col-md-4">
    <select id="unit" name="unit" class="form-control">
        <option value="thing">Thing</option>
        <option value="m">metres</option>
        <option value="m2">square metres</option>
      </select>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="0" class="form-control input-md" >
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Time norm</label>
  <div class="col-md-4">
  <input id="timenorm" name="timenorm" type="text" placeholder="0" class="form-control input-md" >
  </div>
</div>
<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success">Add kind of work</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Cancel</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
