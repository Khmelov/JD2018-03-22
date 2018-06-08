<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<!-- Form Name -->
<legend>Создать категорию</legend>
<form class="form-horizontal" action="do?command=CreateCategory" method="post">

    <fieldset>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Название категории</label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" placeholder="" class="form-control input-md">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Отправить</button>
            </div>
        </div>

    </fieldset>
</form>

<p>Cmd Message: ${message}</p>
</div class="container">
</body>
</html>


