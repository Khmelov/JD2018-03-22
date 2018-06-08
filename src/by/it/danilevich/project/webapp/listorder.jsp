 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
        <div class="row">
                 <div class=col-md-2>Дата</div>
                 <div class=col-md-2>Клиент</div>
                 <div class=col-md-2>Услуга</div>
                 <div class=col-md-2>Исполнитель</div>
                 <div class=col-md-2>Стоимость</div>
                 <div class=col-md-2>Статус</div>
        </div>
            <c:forEach items="${listOrder}" var="order">
                <div class="row">
                    <form class="form-inline order-${order.id}" action="do?command=EditOrder" method=POST>

                        <div class="form-group mb-1">
                            <input id="data" class="form-control input-md" name="data" value="${order.dateOrder}" title=""/>
                        </div>

                        <div class="form-group mb-2">
                            <select id="clientId" name="clientId" class="form-control" title="">

                        <c:forEach items="${listClient}" var="client">
                            <option value="${client.id}" client=${client.id} ${client.id==order.clientId?"selected":""}>
                                    ${client.name}
                            </option>
                        </c:forEach>

                            </select>
                        </div>

                        <div class="form-group mb-2">
                            <select id="workId" name="workId" class="form-control" title="">

                        <c:forEach items="${listWork}" var="work">
                            <option value="${work.id}" ${work.id==order.kindOfWorkId?"selected":""}>
                                    ${work.name}
                            </option>
                        </c:forEach>

                            </select>
                        </div>

                        <div class="form-group mb-2">
                            <select id="executorId" name="executorId" class="form-control" title="">

                        <c:forEach items="${listExecutor}" var="client">
                            <option value="${client.id}" client=${client.id} ${client.id==order.executorId?"selected":""}>
                                    ${client.name}
                            </option>
                        </c:forEach>

                            </select>
                        </div>



                         <div class="form-group mb-1">
                              <input id="totalMoney" class="form-control input-md" name="totalMoney" value="${order.totalMoney}" title=""/>
                          </div>

                     <div class="form-group mb-2">
                        <select id="status" name="status" class="form-control" title="">
                            <c:forEach items="${listStatus}" var="unit">
                               <option value="${unit}" ${order.status==unit?"selected":""}>
                                  ${unit}
                               </option>
                            </c:forEach>
                        </select>
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
                         <input id="id" disabled="disabled" name="id" value="${order.id}"/>
                    </form>.
                </div>
             </c:forEach>
     </div>
</div>
</body>
</html>
