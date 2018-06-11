 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
      <h5>Список заказов пользователя ${user.name}</h5>
<%@ include file="listordershort.jsp" %>
    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="LogoutTrue" class="btn btn-success">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>


</div>
</body>
</html>
