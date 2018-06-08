 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
<form class="form-horizontal" method="post" action="do?command=creatework">
<fieldset>

<!-- Form Name -->
<legend>Создание новой услуги</legend>
<!-- Select Basic -->

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Наименование</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="New kind of work" class="form-control input-md">

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="category">Категория</label>
  <div class="col-md-4">
    <select id="category" name="category" class="form-control">
        <c:forEach var="category" items="${listCategory}">
            <option value = ${category}>${category}</option>
        </c:forEach>
      </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="unit">Единица измерения</label>
  <div class="col-md-4">
    <select id="unit" name="unit" class="form-control">
        <c:forEach var="unit" items="${listUnit}">
            <option value = ${unit}>${unit}</option>
        </c:forEach>
      </select>
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Цена</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="0" class="form-control input-md" >
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Время на исполнение</label>
  <div class="col-md-4">
  <input id="timenorm" name="timenorm" type="text" placeholder="0" class="form-control input-md" >
  </div>
</div>
<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success">Добавить услугу</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Отмена</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
