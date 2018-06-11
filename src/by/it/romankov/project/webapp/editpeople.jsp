<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="row">
        <div class=col-md-1>Имя</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-1>Пароль</div>
        <div class=col-md-1>Логин</div>
       <div class=col-md-1>Возраст</div>
        <div class=col-md-1>Телефон</div>
        <div class=col-md-1>Роль</div>
    </div>


    <c:forEach items="${people}" var="people">
        <div class="row">
            <form class="form-inline people-${people.id}" action="do?command=EditPeople" method=POST>

                <div class=col-md-1>
                    <input id="name" class="form-control input-md" name="name"
                           value="${people.name}" title=""/>
                </div>
                <div class=col-md-2>
                                    <input id="email" class="form-control input-md" name="email"
                                           value="${people.email}" title=""/>
                </div>
                <div class=col-md-1>
                    <input id="password" class="form-control input-md" name="password"
                           value="${people.password}" title=""/>
                </div>
                <div class=col-md-1>
                                    <input id="login" class="form-control input-md" name="login"
                                           value="${people.login}" title=""/>
                 </div>
                  <div class=col-md-1>
                                      <input id="age" class="form-control input-md" name="age"
                                             value="${people.age}" title=""/>
                                  </div>
                   <div class=col-md-1>
                                       <input id="telephone" class="form-control input-md" name="telephone"
                                              value="${people.telephone}" title=""/>
                   </div>

                <div class=col-md-1>
                    <select id="roles_id" name="roles_id" class="form-control" title="">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==people.roles_id?"selected":""}>
                                    ${role.role}
                            </option>
                        </c:forEach>
                    </select>
                </div>


                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

                <div class=col-md-1>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>

                <input id="id" type="hidden" name="id" value="${people.id}"/>


            </form>
        </div>

    </c:forEach>

</div>
</body>
</html>


