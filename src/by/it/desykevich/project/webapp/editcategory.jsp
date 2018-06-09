<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<!-- Form Name -->
<legend>Изменить Категорию</legend>
   <div class="container">
       <div class="row">
           <div class=col-md-2>ID</div>
           <div class=col-md-4>Название</div>

       </div>
   </div>

   <div class="container">
       <c:forEach items="${categories}" var="category">
           <form class="form-horizontal" action="do?command=EditCategory" method=post>

               <div class="row">
                   <div class=col-md-2>
                       <input id="id" class="form-control input-md" name="id"
                              value="${category.id}"/>
                   </div>
                   <div class=col-md-6>
                       <input id="name" class="form-control input-md" name="name"
                              value="${category.name}"/>
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
</div class="container">
</body>
</html>


