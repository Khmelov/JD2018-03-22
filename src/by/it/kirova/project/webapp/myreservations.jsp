<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">



      <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffffff;">
           <a class="navbar-brand" style="font-weight: bold; font-size: 20pt;" href=".">BOOKING.</a>
           <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
           </button>
           <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
               <ul class="navbar-nav">
                   <li class="nav-item">
                       <a class="nav-link" style="font-size: 14pt;" href="do?command=MyAccount">My account</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" style="font-size: 14pt;" href="do?command=MyProperty">My property</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" style="font-size: 14pt;" href="do?command=Logout">Log out</a>
                   </li>
               </ul>
           </div>
       </nav>



 <form class="form-horizontal" method="get" command="do?command=myreservations">
           <fieldset>
              <!-- Form Name -->
                      <legend>My account - My reservations</legend>

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
<div class="row justify-content-left align-items-end">
<div class="col-md-6">
<div class="form-group">
  <label class="col-md-auto control-label" for="totalcost">Total cost</label>
  <div class="col-md-auto">
  <input id="totalcost" readonly name="totalcost" type="text" placeholder="135" class="form-control input-md">

  </div>
  </div>
  </div>

  <div class="col-md-6">
  <div class="form-group">
    <label class="col-md-auto control-label" for="reservationdate">Reservation Date</label>
    <div class="col-md-auto">
    <input id="reservationdate" readonly name="reservationdate" type="text" placeholder="10.10.2018" class="form-control input-md">

    </div>
    </div>
    </div>
    </div>

<div class="row justify-content-left align-items-start">
  <div class="col-md-6">
  <div class="form-group">
    <label class="col-md-auto control-label" for="cancelreservation"></label>
    <div class="col-md-auto">
      <button id="cancelreservation" name="cancelreservation" class="btn btn-danger">CANCEL RESERVATION</button>
    </div>
  </div>
</div>

           </div>


           </fieldset>
           </form>
</div>
</body>
</html>


