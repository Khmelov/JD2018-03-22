<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>


 <form class="form-horizontal" method="get" command="do?command=myreservations">
           <fieldset>
              <!-- Form Name -->


<div class="row justify-content-left align-items-start">
 <div class="col-md-2">
    <ul class="nav navbar-nav nav-pills nav-stacked">
        <li class="active nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyAccount">Edit my account</a>
        </li>

        <li class="nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyReservations">My reservations</a>
        </li>

    </ul>

    </div>





          <div class="col-md-10">
<!-- Text input-->
<div class="row justify-content-left align-items-start">
 <div class="col-md-12">
<div class="form-group">
  <div class="col-md-auto">
      <legend>My account - My reservations</legend>
  </div>
  </div>
</div>
</div>



<div class="row justify-content-left align-items-start">
 <div class="col-md-12">




                                    <c:forEach items="${reservations}" var="row">

                                                <hr />
                                              <form class="form-inline" method=POST >
                                              <div class="row justify-content-left align-items-start">
                                              <div class="col-md-12">

                                                  <div class="row justify-content-left align-items-start">
                                                      <div class="col-md-3">
                                                          <div class="form-group mb-2">
                                                              <label class="col-md-auto control-label" for="reservation_date">Reservation Date</label>
                                                              <div class="col-md-auto">
                                                                  <input id="reservation_date" style="font-size:10pt;" readonly name="reservation_date" class="form-control input-md" value="${row[0]}" title="" />
                                                              </div>
                                                          </div>
                                                      </div>
                                                      </div>

                                                    <div class="row justify-content-left align-items-start">
                                                      <div class="col-md-3">
                                                          <div class="form-group mb-2">
                                                           <label class="col-md-auto control-label" style="font-size:10pt;" for="room_name">Room name</label>
                                                               <div class="col-md-auto">
                                                                  <input id="room_name" style="font-size:10pt;" readonly name="room_name" class="form-control input-md" value="${row[1]}" title="" />
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <div class="col-md-3">
                                                          <div class="form-group mb-2">
                                                           <label class="col-md-auto control-label" for="check_in_date">Check-In Date</label>
                                                              <div class="col-md-auto">
                                                                  <input id="check_in_date" style="font-size:10pt;" readonly name="check_in_date" class="form-control input-md" value="${row[2]}" title="" />
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <div class="col-md-3">
                                                          <div class="form-group mb-2">
                                                           <label class="col-md-auto control-label" for="check_out_date">Check-Out Date</label>
                                                              <div class="col-md-auto">
                                                                  <input id="check_out_date" style="font-size:10pt;" readonly name="check_out_date" class="form-control input-md" value="${row[3]}" title="" />
                                                              </div>
                                                          </div>
                                                      </div>

                                                      <div class="col-md-3">
                                                                                                                <div class="form-group mb-2">
                                                                                                                 <label class="col-md-auto control-label" for="total_cost">Total cost</label>
                                                                                                                    <div class="col-md-auto">
                                                                                                                        <input id="total_cost" style="font-size:10pt;" readonly name="total_cost" class="form-control input-md" value="${row[4]}" title="" />
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


