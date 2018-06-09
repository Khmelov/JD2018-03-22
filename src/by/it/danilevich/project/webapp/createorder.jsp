<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="post" action="do?command=createorder">
<fieldset>

<!-- Form Name -->
<legend>Housing and communal services</legend>
<p>User:<br> ${user}</p>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectkindofworks">Kind of work</label>
  <div class="col-md-4">
    <select id="selectkindofworks" name="selectkindofworks" class="form-control">
        <option value="1">Change pipes in bath</option>
        <option value="2">painting walls</option>
        <option value="3">Change lamp</option>
        <option value="4">Change pipes in kitchen</option>
        <option value="5">painting roof</option>
        <option value="7">Change bath</option>
     </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Amount</label>
  <div class="col-md-4">
  <input id="amount" name="amount" type="text" placeholder="1" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="totalmoney">Price</label>
  <div class="col-md-4">
  <input id="totalmoney" name="totalmoney" type="text" placeholder="0" class="form-control input-md" disabled="disabled" >

  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success">Add order</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Cancel</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
