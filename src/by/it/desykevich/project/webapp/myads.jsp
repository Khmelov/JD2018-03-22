<html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<div class="page-header">
        <h2>My ads</h2>
    </div>

    <br>
    <b>

        <div class="row">
            <div class="col-md-2">Title</div>
            <div class="col-md-2">Category</div>
            <div class="col-md-3">Small Description</div>
            <div class="col-md-4">Description</div>
            <div class="col-md-1">Price</div>
        </div>

    </b>
    <br>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-2">${ad.title} </div>
            <div class="col-md-2">
                <c:forEach items="${categories}" var="category">
                    <c:if test="${category.ID==ad.category_ID}">
                        ${category.name}
                    </c:if>
                </c:forEach>
            </div>
            <div class="col-md-3">${ad.smallDesc} </div>
            <div class="col-md-4">${ad.description} </div>
            <div class="col-md-1">${ad.price}$ </div>
        </div>
        <br>
    </c:forEach>
    <br>

    <div class="row">
        <mytag:paginator count="${adsSize}" step="3" urlprefix="do?command=MyAds&ads="/>
    </div>

    <br>

    <div class="container">
        <div class="row">
            <div class=col-md-1>ID</div>
            <div class=col-md-2>Title</div>
            <div class=col-md-1>SmallDesc</div>
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
                        <input id="ID" class="form-control input-md" name="ID"
                               value="${ad.ID}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="Title" class="form-control input-md" name="Title"
                               value="${ad.title}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="SmallDesc" class="form-control input-md" name="SmallDesc"
                               value="${ad.smallDesc}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="Description" class="form-control input-md" name="Description"
                               value="${ad.description}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="Price" class="form-control input-md" name="Price"
                               value="${ad.price}"/>
                    </div>
                    <div class=col-md-1>
                        <input id="users_ID" class="form-control input-md" name="users_ID"
                               value="${ad.users_ID}"/>
                    </div>
                    <div class=col-md-2>
                        <select id="name" name="category_ID" class="form-control">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.ID}"
                                        role=${category.ID} ${category.ID==ad.category_ID?"selected":""}>
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

