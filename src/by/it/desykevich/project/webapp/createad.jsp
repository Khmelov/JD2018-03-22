<html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=CreateAd" method="post">

<!-- Form Name -->
<legend>Добавить товар</legend>

    <fieldset>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Title">Название</label>
            <div class="col-md-4">
                <input id="Title" name="Title" type="text" placeholder="" class="form-control input-md" required=""
                value="test">
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="category_ID">Category</label>
            <div class="col-md-4">
                        <select id="name" name="category_ID" class="form-control">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.ID}" role=${category.ID} ${category.ID==ad.category_ID?"selected":""}>
                                        ${category.name}
                                </option>
                            </c:forEach>
                        </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Description">Description</label>
            <div class="col-md-4">
                <input id="Description" name="Description" type="text"placeholder="" class="form-control input-md"
                       required="" value="test">
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Price">Price</label>
            <div class="col-md-2">
                <input id="Price" name="Price" type="text" placeholder="" class="form-control input-md"
                value="333">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-outline-primary">Отправить</button>
            </div>
        </div>

    </fieldset>
</form>
<p>Cmd Message: ${message}</p>
</div class="container">
</body>
</html>


