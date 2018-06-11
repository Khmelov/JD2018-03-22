<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <c:set var = "ID" scope = "session" value = "${userRole_id}"/>
<c:choose>
<c:when test="${ID==1}">
<%@ include file="include/menuAdmin.htm" %>
</c:when>
<c:when test="${ID==2}">
<%@ include file="include/menuUser.htm" %>
</c:when>
<c:otherwise>
<%@ include file="include/menu.htm" %>
</c:otherwise>
</c:choose>

    <div class="page-header">
        <h1>Редоктирование ваших объявления</h1>
    </div>

    <div class="row">
        <div class="col-md-1">Цена</div>
        <div class="col-md-2">Адрес</div>
        <div class="col-md-3">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>

    </div>

    <c:forEach items="${listAdsUser}" var="ad">
        <div class="row">
        <form class="form-inline ad-${listAdsUser}" action="do?command=Profile" method=POST>
        <div class="form-group mb-1">
            <input id="price" class="form-control" name="price"
              value="${ad.price}" title=""/>
        </div>
        <div class="form-group mb-2">
            <input id="adress" class="form-control" name="adress"
               value="${ad.adress}" title=""/>
        </div>
        <div class="form-group mb-3">
                    <input id="description" class="form-control" name="description"
                       value="${ad.description}" title=""/>
        </div>
         <div class="form-group mb-1">
             <input id="rooms" class="form-control" name="rooms"
                value="${ad.rooms}" title=""/>
         </div>
         <div class="form-group mb-1">
            <input id="area" class="form-control" name="area"
                    value="${ad.area}" title=""/>
         </div>
         <div class="form-group mb-1">
            <input id="flat" class="form-control" name="flat"
                   value="${ad.flat}" title=""/>
         </div>
         <div class="form-group mb-1">
            <input id="flats" class="form-control" name="flats"
                  value="${ad.flats}" title=""/>
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
                         <input id="id" type="hidden" name="id" value="${ad.id}"/>
         </form>
        </div>
    </c:forEach>

    <br><br>
    <form class="form-horizontal" method="post" action="do?command=Profile">
    <fieldset>
    <!-- Button -->
    <div class="form-group">
      <div class="col-md-4">
        <button id="logout" name="logout" class="btn btn-primary">logout</button>
      </div>
    </div>
    </fieldset>
    </form>
        <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>
        <div class="form-group">
              <div class="col-md-4">
                <button id="createad" name="createad" class="btn btn-primary">Создать объявления</button>
              </div>
            </div>
        </fieldset>
        </form>
</div>
</div>
</body>
</html>
