<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<!-- Form Name -->
<legend>Изменить пользователя</legend>
    <div class="row">
        <div class=col-md-1>id</div>
        <div class=col-md-1>login</div>
        <div class=col-md-1>password</div>
        <div class=col-md-2>email</div>
        <div class=col-md-2>nickname</div>
        <div class=col-md-1>phone number</div>
        <div class=col-md-2>role</div>
    </div>
</div>

<div class="container">

    <c:forEach items="${users}" var="user">
        <form class="form-horizontal" action="do?command=EditUsers" method=post>

            <div class="row">

                <div class=col-md-1>
                    <input id="id" class="form-control input-md" name="id"
                           value="${user.id}"/>
                </div>

                <div class=col-md-1>
                    <input id="login" class="form-control input-md" name="login"
                           value="${user.login}"/>
                </div>

                <div class=col-md-1>
                    <input id="password" class="form-control input-md" name="password"
                           value="${user.password}"/>
                </div>

                <div class=col-md-2>
                    <input id="email" class="form-control input-md" name="email"
                           value="${user.email}"/>
                </div>

                <div class=col-md-2>
                    <input id="nickname" class="form-control input-md" name="nickname"
                           value="${user.nickname}"/>
                </div>

                <div class=col-md-1>
                    <input id="phonenumber" class="form-control input-md" name="phonenumber"
                           value="${user.phonenumber}"/>
                </div>

                <div class=col-md-2>
                    <select id="role" name="roles_id" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>
                                    ${role.role}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class=col-md-1>
                    <button id="Update" value="Update" name="Update" class="btn btn-success">
                        Update
                    </button>
                </div>

                <div class=col-md-1>
                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                        Delete
                    </button>
                </div>
            </div>
        </form>
        <br>
    </c:forEach>
</div class="container">
</body>
</html>


