<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<div class="page-header">

    <h2>Корзина: ${user.nickname}</h2>
    </div>

    <br>
    <b>
        <div class="row">
            <div class="col-md-2">Название</div>
            <div class="col-md-2">Описание</div>
            <div class="col-md-1">Цена</div>

        </div>
    </b>
    <br>

    <c:forEach items="${ads}" var="ad">
            <div class="row">
                <div class="col-md-2">${ad.title} </div>
                <div class="col-md-2">${ad.description} </div>
                <div class="col-md-1">${ad.price} </div>

            </div><br>
    </c:forEach><br>

<div class="row">
        <mytag:paginator count="${adsSize}" step="3" urlprefix="do?command=MyAds&ads="/>
</div>

    <br>

    <!--<div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Title</div>
            <div class=col-md-2>Description</div>
            <div class=col-md-1>Price</div>
            <div class=col-md-1>User ID</div>
            <div class=col-md-2>Category</div>
        </div>
    </div><br>-->

    <!--<div class="container">
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
            </form><br>
        </c:forEach>
    </div>-->
</body>
</html>

