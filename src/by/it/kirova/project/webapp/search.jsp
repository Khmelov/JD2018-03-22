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



 <form class="form-horizontal" method="get" command="do?command=search">
           <fieldset>
              <!-- Form Name -->
                      <legend>Search result:</legend>

<div class="row justify-content-left align-items-start">
          <div class="col-md-12">

          <!-- Text input-->
          <div class="row justify-content-left align-items-start">
          <div class="col-md-3">
          <div class="form-group">
            <label class="col-md-auto control-label" for="hotelname">Hotel name</label>
            <div class="col-md-auto">
            <input id="hotelname" name="hotelname" readonly type="text" placeholder="Resort &amp; Spa" class="form-control input-md" required="">

            </div>
            </div>
          </div>

          <!-- Text input-->
          <div class="col-md-2">
           <div class="form-group">
           <label class="col-md-auto control-label" for="starrating">Star rating</label>
           <div class="col-md-auto">
           <input id="starrating" name="starrating" readonly type="text" placeholder="5" class="form-control input-md" required="">

            </div>
            </div>
            </div>


          <!-- Text input-->
          <div class="col-md-3">
          <div class="form-group">
            <label class="col-md-auto control-label" for="hoteltype">Hotel type</label>
            <div class="col-md-auto">
            <input id="hoteltype" name="hoteltype" readonly  type="text" placeholder="Hotel" class="form-control input-md" required="">

            </div>
            </div>
          </div>



          <!-- Text input-->
           <div class="col-md-4">
          <div class="form-group">
            <label class="col-md-auto control-label" for="country">Address</label>
            <div class="col-md-auto">
            <input id="address" name="address" readonly type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
            </div>
          </div>


<br>
<p> Rooms list:</p>


<!-- Text input-->
  <div class="row justify-content-left align-items-end">
  <div class="col-md-4">
<div class="form-group">
  <label class="col-md-auto control-label" for="roomname">Room name</label>
  <div class="col-md-auto">
  <input id="roomname" name="roomname" type="text" readonly  placeholder="Room with 2 beds" class="form-control input-md" required="">

  </div>
  </div>
</div>


<!-- Text input-->
  <div class="col-md-4">
<div class="form-group">
  <label class="col-md-auto control-label" for="description">Description</label>
  <div class="col-md-auto">
  <input id="description" name="description" readonly  type="text" placeholder="" class="form-control input-md">

  </div>
  </div>
  </div>




<!-- Text input-->

  <div class="col-md-2">
<div class="form-group">
  <label class="col-md-auto control-label" for="cost">Cost</label>
  <div class="col-md-auto">
  <input id="cost" name="cost" type="text" readonly placeholder="204.5" class="form-control input-md" required="">

  </div>
  </div>
</div>

<!-- Button (Double) -->
<div class="col-md-2">
<div class="form-group">
  <label class="col-md-auto control-label" for="reservatebutton"></label>
  <div class="col-md-auto">
    <button id="reservatebutton" name="reservatebutton" class="btn btn-success">BOOKING ROOM</button>
  </div>
  </div>
  </div>
</div>



          </fieldset>
          </form>

</div>
</body>
</html>


