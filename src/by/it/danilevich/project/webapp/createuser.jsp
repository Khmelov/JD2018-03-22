 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <%@ include file="include/menuUser.htm" %>
<p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
<form class="form-horizontal" method="post" action="do?command=createuser">
<fieldset>

<!-- Form Name -->
<legend>Создание нового пользователя</legend>
<!-- Select Basic -->

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Имя</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Адрес</label>
  <div class="col-md-4">
  <input id="address" name="address" type="text" placeholder="" class="form-control input-md">
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="amount">Телефон</label>
  <div class="col-md-4">
  <input id="telephone" name="telephone" type="text" placeholder="" class="form-control input-md">
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="category">Роль</label>
  <div class="col-md-4">
    <select id="roleId" name="roleId" class="form-control">
        <c:forEach var="role" items="${listRole}">
            <option value = ${role.id}>${role.name}</option>
        </c:forEach>
      </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="price">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="0" class="form-control input-md" >
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Пароль</label>
  <div class="col-md-4">
  <input id="password" name="password" type="text" placeholder="0" class="form-control input-md" >
  </div>
</div>
<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success">Добавить пользователя</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Отмена</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>
