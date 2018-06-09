<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<!-- Form Name -->
<legend>Изменить Пользователя</legend>

<div class="container">
    <div class="row">
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-2>Е-mail</div>
        <div class=col-md-2>Ник</div>
        <div class=col-md-2>Телефон</div>
        <div class=col-md-2>Роль</div>
    </div>
</div>
<br>


    <c:forEach items="${users}" var="user">
        <form class="form-horizontal" action="do?command=EditUsers" method=post>
            <div class="row">

            <div class=col-md-1>
                 <input id="ID" class="form-control input-md" name="ID"
                 value="${user.ID}"/>
            </div>

                <div class=col-md-2>
                    <input id="login" class="form-control input-md" name="login"
                           value="${user.login}" title=""/>
                </div>

                 <div class=col-md-2>
                     <input id="email" class="form-control input-md" name="Email"
                            value="${user.email}"/>
                 </div>

                 <div class=col-md-2>
                      <input id="password" class="form-control input-md" name="Password"
                             value="${user.password}"/>
                 </div>

                  <div class=col-md-1>
                       <input id="nickname" class="form-control input-md" name="Nickname"
                              value="${user.nickname}"/>
                   </div>

                  <div class=col-md-2>
                       <input id="phonenumber" class="form-control input-md" name="PhoneNumber"
                              value="${user.phoneNumber}"/>
                  </div>

                  <div class=col-md-2>
                       <select id="role" name="roles_id" class="form-control">
                       <c:forEach items="${roles}" var="role">
                        <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>
                                ${role.role}
                         </option>
                       </c:forEach>
                       </select>
                  </div><br><br>

                  <div class=col-md-4>
                       <button id="Update" value="Update" name="Update" class="btn btn-success">
                        Изменить
                       </button>
                  </div>

                   <div class=col-md-4>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                        </button>
                   </div>





            </div>
        </form>
        <br>
    </c:forEach>


</div class="container">
</body>
</html>


