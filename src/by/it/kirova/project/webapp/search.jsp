<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>



 <form class="form-horizontal" method="post" command="do?command=search">
           <fieldset>
              <!-- Form Name -->
                      <legend>Search result:</legend>

<div class="row justify-content-left align-items-start">
<div class="col-md-12">
                                    <c:forEach items="${searchResult}" var="res">
                                            <form class="form-inline" method=POST >
                                            <div class="row justify-content-left align-items-start">
                                            <div class="col-md-12">
                                                <div class="row justify-content-left align-items-start">
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="hotel.hotel_name">Name</label>
                                                            <div class="col-md-12">
                                                                <input id="hotel.hotel_name" readonly name="hotel.hotel_name" class="form-control input-md" value="${res[0]}" title="" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="hotel.star_rating">Star</label>
                                                                <div class="col-md-12">
                                                                    <input id="hotel.star_rating" readonly name="hotel.star_rating" class="form-control input-md" value="${res[1]}" title="" />
                                                                </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="hotel_type">Type</label>
                                                            <div class="col-md-12">
                                                                <input id="hotel_type" readonly name="hotel_type" class="form-control input-md" value="${res[2]}" title="" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row justify-content-left align-items-start">
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="hotel.street">Street</label>
                                                            <div class="col-md-12">
                                                                <input id="hotel.street" readonly name="hotel.street" class="form-control input-md" value="${res[3]}" title="" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="hotel.house_number">House Number</label>
                                                            <div class="col-md-12">
                                                                <input id="hotel.house_number" readonly name="hotel.house_number" class="form-control input-md" value="${res[4]}" title="" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="room.room_name">Room Name</label>
                                                            <div class="col-md-12">
                                                                <input id="room.room_name" readonly name="room.room_name" class="form-control input-md" value="${res[5]}" title="" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    </div>
                                                    <div class="row justify-content-left align-items-start">
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="room.people_amount">People amount</label>
                                                            <div class="col-md-12">
                                                                <input id="room.people_amount" readonly name="room.people_amount" class="form-control input-md" value="${res[6]}" title="" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="room.description">Description</label>
                                                                <div class="col-md-12">
                                                             <input id="room.description" readonly name="room.description" class="form-control input-md" value="${res[7]}" title="" />
                                                                </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="form-group mb-2">
                                                            <label class="col-md-auto control-label" for="room.cost">Cost per night</label>
                                                                <div class="col-md-12">
                                                            <input id="room.cost" readonly name="room.cost" class="form-control input-md" value="${res[8]}" title="" />
                                                                </div>
                                                        </div>
                                                    </div>
                                                    </div>
                                                <div class="row justify-content-end align-items-end">
                                                <div class="col-md-12 text-right">
                                                <div class="form-group mb-2">
                                                  <div class="col-md-12">
                                                    <button id="booking" name="booking" class="btn btn-default">BOOKING</button>
                                                    </div>
                                                    </div>
                                                    </div>
                                                </div>
                                                <hr />
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


