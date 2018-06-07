 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
    <p> ${listWork}</p>
    <div class="row">
             <div class=col-md-2>Наименование</div>
             <div class=col-md-2>Категория</div>
             <div class=col-md-2>Ед.изм.</div>
             <div class=col-md-2>Цена</div>
             <div class=col-md-2>Норма времени</div>
    </div>
</div>
</body>
</html>
