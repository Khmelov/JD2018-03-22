<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <html>
    <%@ include file="include/head.htm" %>

        <body>
            <div class="container">
                <%@ include file="include/menu.htm" %>

                    <form class="form-horizontal" method="post" command="do?command=viewrooms">
                        <fieldset>
                            <!-- Form Name -->

                            <div class="row justify-content-left align-items-start">
                                <div class="col-md-2">
                                    <ul class="nav navbar-nav nav-pills nav-stacked">
                                        <li class="nav-item">
                                            <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyProperty">Add new property</a>
                                        </li>

                                        <li class="nav-item">
                                            <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=EditMyProperty">Edit my property</a>
                                        </li>

                                    </ul>

                                </div>

                                <div class="col-md-10">

                                ${rooms}

                                    <div class="row justify-content-left align-items-start">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="col-md-auto">
                                                    <legend>My account - Edit my property - View rooms</legend>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6 text-right">
                                            <div class="form-group">
                                                <div class="col-md-auto">
                                                    <button id="addroom" name="addroom" class="btn btn-default">ADD ROOM</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row justify-content-left align-items-start">
                                        <div class="col-md-12">
                                            <c:forEach items="${rooms}" var="room">
                                                <hr />
                                                <form class="form-inline" method=POST>
                                                    <div class="row justify-content-left align-items-start">
                                                        <div class="col-md-12">

                                                            <div class="row justify-content-left align-items-start">
                                                                <div class="col-md-4">
                                                                    <div class="form-group mb-2">
                                                                        <label class="col-md-auto control-label" for="room_name">Room name</label>
                                                                        <div class="col-md-12">
                                                                            <input id="room_name" name="room_name" readonly class="form-control input-md" value="${room.room_name}" title="" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group mb-2">
                                                                        <label class="col-md-auto control-label" for="room_fact_number">Room Number</label>
                                                                        <div class="col-md-12">
                                                                            <input id="room_fact_number" name="room_fact_number" readonly class="form-control input-md" value="${room.room_fact_number}" title="" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group mb-2">
                                                                        <label class="col-md-auto control-label" for="people_amount">People amount</label>
                                                                        <div class="col-md-12">
                                                                            <input id="people_amount" readonly name="people_amount" class="form-control input-md" value="${room.people_amount}" title="" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row justify-content-left align-items-start">
                                                                <div class="col-md-4">
                                                                    <div class="form-group mb-2">
                                                                        <label class="col-md-auto control-label" for="description">Description</label>
                                                                        <div class="col-md-12">
                                                                            <input id="description" readonly name="description" class="form-control input-md" value="${room.description}" title="" />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group mb-2">
                                                                        <label class="col-md-auto control-label" for="cost">Cost</label>
                                                                        <div class="col-md-12">
                                                                            <input id="cost" readonly name="cost" class="form-control input-md" value="${room.cost}" title="" />
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <!-- Button (Double) -->
                                                                <div class="col-md-4">
                                                                    <div class="form-group mb-2">
                                                                        <label class="col-md-6 control-label" for="savebutton"></label>
                                                                        <div class="col-md-auto">
                                                                            <button id="updateroom" name="updateroom" class="btn btn-success">UPDATE</button>
                                                                            <button id="deleteroom" name="deleteroom" class="btn btn-danger">DELETE</button>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>

                                                </form>

                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>

                            </div>
                        </fieldset>
                    </form>

            </div>
        </body>

    </html>