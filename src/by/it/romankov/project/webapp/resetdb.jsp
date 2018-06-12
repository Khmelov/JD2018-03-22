<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <div class="row">
        <div class=col-md-1>Цель</div>
        <div class=col-md-2>Транспорт</div>
        <div class=col-md-1>Страна</div>
        <div class=col-md-1>Город</div>
       <div class=col-md-1>Цена</div>
        <div class=col-md-1>Дни</div>
    </div>


    <c:forEach items="${listTours}" var="tour">
        <div class="row">
            <form class="form-inline tour-${tour.id}" action="do?command=resetdb" method=POST>

                <div class=col-md-1>
                    <input id="target" class="form-control input-md" name="target"
                           value="${tour.target}" title=""/>
                </div>
                <div class=col-md-2>
                                    <input id="transport" class="form-control input-md" name="transport"
                                           value="${tour.transport}" title=""/>
                </div>
                <div class=col-md-1>
                    <input id="country" class="form-control input-md" name="country"
                           value="${tour.country}" title=""/>
                </div>
                <div class=col-md-1>
                                    <input id="city" class="form-control input-md" name="city"
                                           value="${tour.city}" title=""/>
                 </div>
                  <div class=col-md-1>
                                      <input id="price" class="form-control input-md" name="price"
                                             value="${tour.price}" title=""/>
                                  </div>
                   <div class=col-md-1>
                                       <input id="days" class="form-control input-md" name="days"
                                              value="${tour.days}" title=""/>
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

                <input id="id" type="hidden" name="id" value="${tour.id}"/>
                <input id="people_id" type="hidden" name="people_id" value="${tour.people_id}"/>


            </form>
        </div>

    </c:forEach>
<form class="form-horizontal" method=POST action"do?command=resetdb">
<fieldset>

               <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="ок"></label>
                    <div class="col-md-4">
                        <button id="ok" name="ok" value="ok" class="btn btn-primary">сбросить</button>
                    </div>
                </div>

</fieldset>
</form>



</div>
</body>
</html>


