<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <c:set var = "ID" scope = "session" value = "${userRole_id}"/>
<c:choose>
<c:when test="${ID==1}">
<%@ include file="include/menuAdmin.htm" %>
</c:when>
<c:when test="${ID==2}">
<%@ include file="include/menuUser.htm" %>
</c:when>
<c:otherwise>
<%@ include file="include/menu.htm" %>
</c:otherwise>
</c:choose>
<form class="form-horizontal" method="post" action="do?command=createad">
<fieldset>

<!-- Form Name -->
<legend>Форма для создания нового объявления</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description"></label>
       <div class="col-md-4">
  <input id="description" name="description" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Описание</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="rooms"></label>
       <div class="col-md-4">
  <input id="rooms" name="rooms" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Количество комнат</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price"></label>
     <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Стоимость</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
 <label class="col-md-4 control-label" for="area"></label>
   <div class="col-md-4">
  <input id="area" name="area" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Площадь</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="flat"></label>
  <div class="col-md-4">
  <input id="flat" name="flat" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Этаж</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="flats"></label>
  <div class="col-md-4">
  <input id="flats" name="flats" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Этажей в доме</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="adress"></label>
  <div class="col-md-4">
  <input id="adress" name="adress" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Адрес</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">create</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>