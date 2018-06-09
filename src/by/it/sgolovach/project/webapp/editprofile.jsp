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

    <div class="row">
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-2>Email</div>
    </div>
    <form class="form-inline user-${userone.id}" action="do?command=EditProfile" method=POST>

                    <div class="form-group mb-2">
                        <input id="login" class="form-control input-md" name="login"
                               value="${userone.login}" title=""/>
                    </div>
                    <div class="form-group mb-2">
                        <input id="password" class="form-control input-md" name="password"
                               value="${userone.password}" title=""/>
                    </div>
                    <div class="form-group mb-2">
                        <input id="email" class="form-control input-md" name="email"
                               value="${userone.email}" title=""/>
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




                </form>

</div>
</body>
</html>