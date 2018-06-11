<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="page-header">
        <legend>Редактирование товаров</legend>
    </div>

    <div class="row">
        <div class=col-md-3>Название</div>
        <div class=col-md-3>Описание</div>
        <div class=col-md-3>Стоимость</div>
    </div>

    <c:forEach items="${listGoods}" var="product">
        <div class="row">
            <form class="form-inline product-${listGoods}" action="do?command=EditProduct" method=POST>

                <div class="form-group mb-3">
                    <input id="name" class="form-control input-md" name="name"
                           value="${product.name}" title=""/>
                </div>
                <div class="form-group mb-3">
                           <input id="description" class="form-control" name="description"
                           value="${product.description}" title=""/>
                </div>
                <div class="form-group mb-3">
                            <input id="price" class="form-control" name="price"
                            value="${product.price}" title=""/>
                </div>
                <input id="id" type="hidden" name="id" value="${product.id}"/>

                <div class="form-group mb-3">
                    <button id="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

                <div class="form-group mb-3">
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>

            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>


