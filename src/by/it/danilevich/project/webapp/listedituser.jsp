 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <%@ include file="include/menuUser.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>

    <div class="row">
                 <div class=col-md-2>Имя</div>
                 <div class=col-md-2>Роль</div>
                 <div class=col-md-2>Адрес</div>
                 <div class=col-md-2>Логин</div>
                 <div class=col-md-2>Пароль</div>
    </div>
            <c:forEach items="${listUser}" var="user">
                <div class="row">
                    <form class="form-inline user-${user.id}" action="do?command=EditUser" method=POST>

                        <div class="form-group mb-1">
                            <input id="name" class="form-control input-md" name="name" value="${user.name}" title=""/>
                        </div>

                        <div class="form-group mb-2">
                            <select id="roleId" name="roleId" class="form-control" title="">

                                <c:forEach items="${listRole}" var="role">
                                    <option value="${role.id}" ${role.id==user.roleId?"selected":""}>
                                        ${role.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>


                         <div class="form-group mb-1">
                              <input id="address" class="form-control input-md" name="address" value="${user.address}" title=""/>
                          </div>

                         <div class="form-group mb-1">
                              <input id="login" class="form-control input-md" name="login" value="${user.login}" title=""/>
                          </div>

                         <div class="form-group mb-1">
                           <input id="password" class="form-control input-md" name="password" value="${user.password}" title=""/>
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
                         <input id="id" name="id" value="${user.id}" type="hidden"/>
                    </form>.
                </div>
             </c:forEach>

</div>
</body>
</html>
