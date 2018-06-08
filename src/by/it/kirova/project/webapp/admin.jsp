<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>




        <c:forEach items="${users}" var="user">
            <div class="row">
                <form class="form-inline user-${user.user_id}" action="do?command=Admin" method=POST>

                     <div class="form-group mb-2">
                        <input id="email" class="form-control input-md" name="email"
                               value="${user.email}" title=""/>
                    </div>
                    <div class="form-group mb-2">
                        <input id="password" class="form-control input-md" name="password"
                               value="${user.password}" title=""/>
                    </div>

                    <div class="form-group mb-2">
                        <input id="first_name" class="form-control input-md" name="first_name"
                               value="${user.first_name}" title=""/>
                    </div>

                    <div class="form-group mb-2">
                        <input id="last_name" class="form-control input-md" name="last_name"
                               value="${user.last_name}" title=""/>
                    </div>

                     <div class="form-group mb-2">
                          <input id="middle_name" class="form-control input-md" name="middle_name"
                                value="${user.middle_name}" title=""/>
                     </div>
                       <div class="form-group mb-2">
                          <input id="residence_country" class="form-control input-md" name="residence_country"
                                value="${user.residence_country}" title=""/>
                     </div>
                       <div class="form-group mb-2">
                       <input id="phone_number" class="form-control input-md" name="phone_number"
                                 value="${user.phone_number}" title=""/>
                      </div>

                    <div class="form-group mb-2">
                        <select id="role_id" name="role_id" class="form-control" title="">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.role_id}" role=${role.role_id} ${role.role_id==user.role_role_id?"selected":""}>
                                        ${role.role_name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="form-group mb-1">
                        <button id="Update" name="Update" class="btn btn-success">
                            Update
                        </button>
                    </div>

                    <div class="form-group mb-1">
                        <button id="Delete" name="Delete" class="btn btn-danger">
                            Delete
                        </button>
                    </div>

                    <input id="user_id" type="hidden" name="user_id" value="${user.user_id}"/>


                </form>
            </div>

        </c:forEach>

    </div>
    </body>
    </html>

