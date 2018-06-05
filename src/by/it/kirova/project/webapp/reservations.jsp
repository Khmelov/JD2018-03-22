<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>




 <form class="form-horizontal" method="get" command="do?command=reservations">
           <fieldset>
              <!-- Form Name -->
                      <legend>My property - Reservations</legend>

<div class="row justify-content-left align-items-start">
 <div class="col-md-2">
    <ul class="nav navbar-nav nav-pills nav-stacked">
        <li class="nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyProperty">Add new property</a>
        </li>

        <li class="nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=EditMyProperty">Edit my property</a>
        </li>

         <li class="active nav-item">
         <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=Reservations">Reservations</a>
         </li>

    </ul>

    </div>






          <div class="col-md-10">
<!-- Text input-->
<div class="row justify-content-left align-items-start">
 <div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="checkindate">Check-In Date</label>
  <div class="col-md-auto">
  <input id="checkindate" readonly name="checkindate" type="text" placeholder="01.01.2018" class="form-control input-md">

  </div>
  </div>
</div>

<!-- Text input-->
<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="checkoutdate">Check-Out Date</label>
  <div class="col-md-auto">
  <input id="checkoutdate" readonly name="checkoutdate" type="text" placeholder="01.01.2018" class="form-control input-md">

  </div>
  </div>
  </div>
</div>

<!-- Text input-->
<div class="row justify-content-left align-items-start">
<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="hotelname">Hotel</label>
  <div class="col-md-auto">
  <input id="hotelname" readonly name="hotelname" type="text" placeholder="test name" class="form-control input-md">

  </div>
  </div>
</div>

<!-- Text input-->

<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="address">Address</label>
  <div class="col-md-auto">
  <input id="address" readonly name="address" type="text" placeholder="Country, City, Street, HouseNumber" class="form-control input-md">

  </div>
  </div>
  </div>
</div>

<!-- Text input-->
<div class="row justify-content-left align-items-start">
<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="roomname">Room</label>
  <div class="col-md-auto">
  <input id="roomname" readonly name="roomname" type="text" placeholder="test name" class="form-control input-md">

  </div>
  </div>
</div>

<!-- Text input-->
<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="peopleamount">People amount</label>
  <div class="col-md-auto">
  <input id="peopleamount" readonly name="peopleamount" type="text" placeholder="2" class="form-control input-md">

  </div>
  </div>
  </div>
</div>

<!-- Text input-->
<div class="row justify-content-left align-items-start">
<div class="col-md-6">
<div class="form-group">
   <label class="col-md-auto control-label" for="firstname">First name user</label>
    <div class="col-md-auto">
   <input id="firstname" value="testName" readonly name="firstname" type="text" placeholder="first name" class="form-control input-md" required="">

  </div>
  </div>
</div>

<!-- Text input-->
<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="lastname">Last name user</label>
  <div class="col-md-auto">
<input id="lastname" value="testLastName" readonly name="lastname" type="text" placeholder="last name" class="form-control input-md" required="">

  </div>
  </div>
  </div>
</div>

<!-- Text input-->
<div class="row justify-content-left align-items-end">
<div class="col-md-6">
<div class="form-group">
   <label class="col-md-auto control-label" for="phonenumber">Phone number</label>
    <div class="col-md-auto">
     <input id="phonenumber" value="+375 29 111 11 11" readonly name="phonenumber" type="text" placeholder="phone number" class="form-control input-md" required="">
     </div>
  </div>
</div>



<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="totalcost">Total cost</label>
  <div class="col-md-auto">
  <input id="totalcost" readonly name="totalcost" type="text" placeholder="135" class="form-control input-md">

  </div>
  </div>
  </div>
  </div>




           </fieldset>
           </form>
</div>
</body>
</html>


