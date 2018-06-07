<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="row">
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Роль</div>
    </div>


    <c:forEach items="${users}" var="user">
        <div class="row">
            <form class="form-inline user-${user.id}" action="do?command=EditUsers" method=POST>

                <div class="form-group mb-2">
                    <input id="login" class="form-control input-md" name="login"
                           value="${user.login}" title=""/>
                </div>
                <div class="form-group mb-2">
                    <input id="password" class="form-control input-md" name="password"
                           value="${user.password}" title=""/>
                </div>
                <div class="form-group mb-2">
                    <input id="email" class="form-control input-md" name="email"
                           value="${user.email}" title=""/>
                </div>
                <div class="form-group mb-2">
                    <select id="roles_id" name="roles_id" class="form-control" title="">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>
                                    ${role.role}
                            </option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group mb-1">
                    <button id="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

                <div class="form-group mb-1">
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>

                <input id="id" type="hidden" name="id" value="${user.id}"/>


            </form>
        </div>

    </c:forEach>

</div>
</body>
</html>


