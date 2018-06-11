 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <%@ include file="include/menuWork.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name}     Права:${userRole}</p>
    <div class="row">
             <div class=col-md-2>Наименование</div>
             <div class=col-md-2>Категория</div>
             <div class=col-md-2>Ед.изм.</div>
             <div class=col-md-2>Цена(бел.руб.)</div>
             <div class=col-md-2>Норма времени(мин.)</div>
    </div>
        <c:forEach items="${listWork}" var="work">
            <div class="row">
                <form class="form-inline user-${user.id}" action="do?command=EditWork" method=POST>

                    <div class="form-group mb-2">
                        <input id="name" class="form-control input-md" name="name" value="${work.name}" title=""/>
                    </div>

                    <div class="form-group mb-2">
                        <select id="category" name="category" class="form-control" title="">
                            <c:forEach items="${listCategory}" var="category">
                                <option value="${category}" ${work.category==category?"selected":""}>
                                        ${category}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                     <div class="form-group mb-2">
                        <select id="unit" name="unit" class="form-control" title="">
                            <c:forEach items="${listUnit}" var="unit">
                               <option value="${unit}" ${work.unit==unit?"selected":""}>
                                  ${unit}
                               </option>
                            </c:forEach>
                        </select>
                     </div>
                        <div class="form-group mb-2">
                            <input id="price" class="form-control input-md" name="price" value="${work.price}" title=""/>
                        </div>
                        <div class="form-group mb-2">
                            <input id="timenorm" class="form-control input-md" name="timenorm" value="${work.timeNorm}" title=""/>
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

                    <input id="id" type="hidden" name="id" value="${work.id}"/>


                </form>.
            </div>

        </c:forEach>




</div>
</body>
</html>
