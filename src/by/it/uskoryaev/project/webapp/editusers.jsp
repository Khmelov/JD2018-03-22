<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="row">
        <div class=col-md-3>Имя</div>
        <div class=col-md-3>Пароль</div>
        <div class=col-md-3>Email</div>
    </div>


    <c:forEach items="${users}" var="user">
        <div class="row">
            <form class="form-inline user-${user.user_id}" action="do?command=EditUsers" method=POST>

                <div class="form-group mb-2">
                    <input id="nickName" class="form-control input-md" name="nickName"
                           value="${user.nick_Name}" title=""/>
                </div>
                <div class="form-group mb-2">
                    <input id="password" class="form-control input-md" name="password"
                           value="${user.password}" title=""/>
                </div>
                <div class="form-group mb-2">
                    <input id="email" class="form-control input-md" name="email"
                           value="${user.email}" title=""/>
                </div>

                <div class="form-group mb-1">
                    <button id="Update" name="Update" class="btn btn-default">
                        Обновить
                    </button>
                </div>

                <div class="form-group mb-1">
                    <button id="Delete" name="Delete" class="btn btn-default">
                        Удалить
                    </button>
                </div>


            </form>
        </div>

    </c:forEach>

</div>
</body>
</html>


