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



                                        <div style="font-size: 12pt;">
                                         <div class="row">
                                             <div class=col-md-auto>Name</div>
                                             <div class=col-md-auto>Type</div>
                                             <div class=col-md-auto>Stars</div>
                                             <div class=col-md-auto>Country</div>
                                             <div class=col-md-auto>City</div>
                                             <div class=col-md-auto>Street</div>
                                             <div class=col-md-auto>House number</div>
                                             <div class=col-md-auto>Contact Email</div>
                                             <div class=col-md-auto>Contact phone</div>
                                         </div>
                                         </div>

                                         <div class="table-responsive">

                                         <c:forEach items="${hotels}" var="hotel">
                                             <div class="row">


                                                 <form class="form-inline hotel-${hotel_id}" method=POST>





                                                      <div class="form-group md">
                                                      <div class="col-xs-auto">
                                                         <input id="hotel_name" style="font-size: 9pt;" class="form-control input-md" name="hotel_name"
                                                                value="${hotel.hotel_name}" title=""/>
                                                     </div>
                                                     </div>
                                                      <div class="form-group md">
                                                      <div class="col-xs-auto">
                                                         <input id="hotel_type" style="font-size: 9pt;" style="font-size: 9pt;" class="form-control input-md" name="hotel_type"
                                                                value="${hotel.hotel_type}" title=""/>
                                                     </div>
                                                     </div>
                                                       <div class="form-group md">
                                                       <div class="col-xs-auto">
                                                          <input id="star_rating" style="font-size: 9pt;" class="form-control input-md" name="star_rating"
                                                                value="${hotel.star_rating}" title=""/>
                                                     </div>
                                                     </div>
                                                      <div class="form-group md">
                                                      <div class="col-xs-auto">
                                                         <input id="country" style="font-size: 9pt;" class="form-control input-md" name="country"
                                                                value="${hotel.country}" title=""/>
                                                     </div>
                                                     </div>
                                                     <div class="form-group md">
                                                     <div class="col-xs-auto">
                                                         <input id="city" style="font-size: 9pt;" class="form-control input-md" name="city"
                                                                value="${hotel.city}" title=""/>
                                                     </div>
                                                     </div>
                                                      <div class="form-group xs-2">
                                                      <div class="col-auto">
                                                          <input id="street" style="font-size: 9pt;" class="form-control input-md" name="street"
                                                                value="${hotel.street}" title=""/>
                                                     </div>
                                                     </div>
                                                     <div class="form-group xs-2">
                                                     <div class="col-auto">
                                                          <input id="house_number" style="font-size: 9pt;" class="form-control input-md" name="house_number"
                                                                value="${hotel.house_number}" title=""/>
                                                     </div>
                                                      </div>
                                                      <div class="form-group xs-2">
                                                      <div class="col-auto">
                                                          <input id="contact_email" style="font-size: 9pt;" class="form-control input-md" name="contact_email"
                                                                value="${hotel.contact_email}" title=""/>
                                                      </div>
                                                      </div>
                                                      <div class="form-group xs-2">
                                                      <div class="col-auto">
                                                           <input id="contact_phone_number" style="font-size: 9pt;" class="form-control input-md" name="contact_phone_number"
                                                                 value="${hotel.contact_phone_number}" title=""/>
                                                      </div>
                                                      </div>


                                                     <div class="form-group xs-2">
                                                     <div class="col-auto">
                                                         <button id="Update" style="font-size: 9pt;" name="Update" class="btn btn-success">
                                                             Update
                                                         </button>
                                                     </div>
                                                     </div>

                                                     <div class="form-group xs-2">
                                                     <div class="col-auto">
                                                         <button id="Delete" style="font-size: 9pt;" name="Delete" class="btn btn-danger">
                                                             Delete
                                                         </button>
                                                     </div>
                                                     </div>

                                                     <input id="id" type="hidden" name="id" value="${hotel_id}"/>

                                                 </form>
                                             </div>


                                         </c:forEach>
                                         </div>


                                </div>
                            </div>

                        </fieldset>
                    </form>

            </div>
        </body>

    </html>