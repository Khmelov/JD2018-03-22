<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<div class="page-header">
        <h2>Корзина</h2>
    </div>

    <br>
    <b>

        <div class="row">
            <div class="col-md-2">Название</div>
            <div class="col-md-2">Категория</div>
            <div class="col-md-4">Описание</div>
            <div class="col-md-1">Цена</div>
        </div>

    </b>
    <br>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-2">${ad.title} </div>
            <div class="col-md-2">
                <c:forEach items="${categories}" var="category">
                    <c:if test="${category.id==ad.category_id}">
                        ${category.name}
                    </c:if>
                </c:forEach>
            </div>

            <div class="col-md-4">${ad.description} </div>
            <div class="col-md-1">${ad.price}$ </div>
        </div>
        <br>
    </c:forEach>
    <br>

    <div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Title</div>
            <div class=col-md-2>Description</div>
            <div class=col-md-1>Price</div>
            <div class=col-md-1>User ID</div>
            <div class=col-md-2>Category</div>
        </div>
    </div>

    <br>
    <div class="container">
        <c:forEach items="${ads}" var="ad">
            <form class="form-horizontal" action="do?command=MyAds" method=post>
                <div class="row">

                    <div class=col-md-1>
                        <input id="id" class="form-control input-md" name="id"
                               value="${ad.id}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="title" class="form-control input-md" name="title"
                               value="${ad.title}"/>
                    </div>

                    <div class=col-md-2>
                        <input id="description" class="form-control input-md" name="description"
                               value="${ad.description}"/>
                    </div>

                    <div class=col-md-1>
                        <input id="price" class="form-control input-md" name="price"
                               value="${ad.price}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="users_id" class="form-control input-md" name="users_id"
                               value="${ad.users_id}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="name" name="category_id" class="form-control">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}"
                                        role=${category.id} ${category.id==ad.category_id?"selected":""}>
                                        ${category.name}
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
    </div>
</div>
</body>
</html>

