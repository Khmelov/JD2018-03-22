 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
<p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
    <p>All orders of User:<br> ${listOrder}</p>

    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="LogoutTrue" class="btn btn-success">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
