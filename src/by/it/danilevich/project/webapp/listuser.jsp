 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
    <div class="row">
      <h2>Список пользователей</h2>
      <table class="table">
        <thead>
          <tr>
            <th>id</th>
            <th>Имя</th>
            <th>Роль</th>
            <th>Адрес</th>
            <th>Телефон</th>
            <th>Логин</th>
            <th>Пароль</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${listUser}" var="user">
            <tr>
              <td>${user.id}</td>
              <td>${user.name}</td>
              <td> ROL</td>
              <td>${user.address}</td>
              <td>${user.telephone}</td>
              <td>${user.login}</td>
              <td>${user.password}</td>
             </tr>
            </c:forEach>

        </tbody>
      </table>
    </div>
</div>
</body>
</html>
