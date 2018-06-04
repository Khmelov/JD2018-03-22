<html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<!-- Form Name -->
<legend>Изменить пользователя</legend>
    <div class="row">
        <div class=col-md-1>ID</div>
        <div class=col-md-1>Login</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-1>Password</div>
        <div class=col-md-2>Nickname</div>
        <div class=col-md-1>Phone Number</div>
        <div class=col-md-2>Role</div>
    </div>
</div>

<div class="container">
    <c:forEach items="${users}" var="user">
        <form class="form-horizontal" action="do?command=EditUsers" method=post>
            <div class="row">
                <div class=col-md-1>
                    <input id="ID" class="form-control input-md" name="ID"
                           value="${user.ID}"/>
                </div>
                <div class=col-md-1>
                    <input id="login" class="form-control input-md" name="Login"
                           value="${user.login}"/>
                </div>
                <div class=col-md-2>
                    <input id="email" class="form-control input-md" name="Email"
                           value="${user.email}"/>
                </div>
                <div class=col-md-1>
                    <input id="password" class="form-control input-md" name="Password"
                           value="${user.password}"/>
                </div>
                <div class=col-md-2>
                    <input id="nickname" class="form-control input-md" name="Nickname"
                           value="${user.nickname}"/>
                </div>
                <div class=col-md-1>
                    <input id="phonenumber" class="form-control input-md" name="PhoneNumber"
                           value="${user.phoneNumber}"/>
                </div>

                <div class=col-md-2>
                    <select id="role" name="roles_ID" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.ID}" role=${role.ID} ${role.ID==user.roles_ID?"selected":""}>
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


