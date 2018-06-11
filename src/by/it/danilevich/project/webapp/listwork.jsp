 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <%@ include file="include/menuWork.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
    <div class="row">
      <h2>Список Услуг</h2>
      <table class="table">
        <thead>
          <tr>
            <th>id</th>
            <th>Наименование</th>
            <th>Категория</th>
            <th>Ед.изм</th>
            <th>Цена(бел.руб.)</th>
            <th>Норма времени</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${listWork}" var="work">
            <tr>
              <td>${work.id}</td>
              <td>${work.name}</td>
              <td>${work.category}</td>
              <td>${work.unit}</td>
              <td>${work.price}</td>
              <td>${work.timeNorm}</td>
             </tr>
            </c:forEach>
        </tbody>
      </table>
    </div>
</div>
</body>
</html>