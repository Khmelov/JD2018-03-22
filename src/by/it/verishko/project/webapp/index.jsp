<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
    <div class="page-header">
        <legend>Все объявления</legend>
        <p class="lead"></p>
    </div>

    <div class="row">
        <div class="col-md-4">Название</div>
        <div class="col-md-4">Описание</div>
        <div class="col-md-4">Стоимость</div>
    </div>

    <c:forEach items="${goods}" var="product">
        <div class="row">
            <div class="col-md-4">${product.name} </div>
            <div class="col-md-4">${product.description} </div>
            <div class="col-md-4">${product.price} </div>
        </div>
    </c:forEach>

    <br><br>
</div>
</body>
</html>