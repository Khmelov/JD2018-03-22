<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <html>
    <%@ include file="include/head.htm" %>

        <body>
            <div class="container">
                <%@ include file="include/menu.htm" %>

                    <form class="form-horizontal" method="post" command="do?command=editmyproperty">
                        <fieldset>
                            <!-- Form Name -->

                            <div class="row justify-content-left align-items-start">
                                <div class="col-md-2">
                                    <ul class="nav navbar-nav nav-pills nav-stacked">
                                        <li class="nav-item">
                                            <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyProperty">Add new property</a>
                                        </li>

                                        <li class="active nav-item">
                                            <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=EditMyProperty">Edit my property</a>
                                        </li>

                                    </ul>

                                </div>

                                <div class="col-md-10">

                                    <div class="row justify-content-left align-items-start">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <div class="col-md-auto">
                                                    <legend>My property - Edit my property</legend>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <c:forEach items="${hotels}" var="hotel">

                                        <hr />
                                        <form class="form-inline hotel-${hotel.hotel_id}" method=POST>
                                            <div class="row justify-content-left align-items-start">
                                                <div class="col-md-12">

                                                    <input id="hotel_id" type="hidden" name="hotel_id" value="${hotel.hotel_id}" />

                                                    <div class="row justify-content-left align-items-start">
                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="hotel_name">Name</label>
                                                                <div class="col-md-12">
                                                                    <input id="hotel_name" name="hotel_name" class="form-control input-md" value="${hotel.hotel_name}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="hotel_type">Type</label>
                                                                <div class="col-md-12">
                                                                    <input id="hotel_type" name="hotel_type" class="form-control input-md" value="${hotel.hotel_type}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="star_rating">Star</label>
                                                                <div class="col-md-12">
                                                                    <input id="star_rating" name="star_rating" class="form-control input-md" value="${hotel.star_rating}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="row justify-content-left align-items-start">
                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="country">Country</label>
                                                                <div class="col-md-12">
                                                                    <input id="country" name="country" class="form-control input-md" value="${hotel.country}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="city">City</label>
                                                                <div class="col-md-12">
                                                                    <input id="city" name="city" class="form-control input-md" value="${hotel.city}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="street">Street</label>
                                                                <div class="col-md-12">
                                                                    <input id="street" name="street" class="form-control input-md" value="${hotel.street}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="row justify-content-left align-items-start">
                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="house_number">House Number</label>
                                                                <div class="col-md-12">
                                                                    <input id="house_number" name="house_number" class="form-control input-md" value="${hotel.house_number}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="contact_email">Contact Email</label>
                                                                <div class="col-md-12">
                                                                    <input id="contact_email" name="contact_email" class="form-control input-md" value="${hotel.contact_email}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group mb-2">
                                                                <label class="col-md-auto control-label" for="contact_phone_number">Contact phone number</label>
                                                                <div class="col-md-12">
                                                                    <input id="contact_phone_number" name="contact_phone_number" class="form-control input-md" value="${hotel.contact_phone_number}" title="" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="row justify-content-end align-items-end">
                                                        <div class="col-md-6 text-right">
                                                            <div class="form-group mb-2">
                                                                <div class="col-md-12">
                                                                    <button id="update" name="update" class="btn btn-white">UPDATE HOTEL</button>
                                                                    <button id="delete" name="delete" class="btn btn-primary">DELETE HOTEL</button>
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

                        </fieldset>
                    </form>

            </div>
        </body>

    </html>