<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
   <form class="form-horizontal" method="get" command="do?command=index">
   <fieldset>


   <!-- Form Name -->
   <legend></legend>

	<div class="row justify-content-center align-items-end">

<!-- Form Name -->
<legend></legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-auto control-label" for="destination">Destination</label>
  <div class="col-md-auto">
  <input id="destination" value="Vienna" name="destination" type="text" placeholder="Vienna" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-auto control-label" for="checkindate">Check-In Date</label>
  <div class="col-md-auto">
  <input id="checkindate" value="10.10.2018" name="checkindate" type="text" placeholder="05.10.2018" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-auto control-label" for="checkoutdate">Check-Out Date</label>
  <div class="col-md-auto">
  <input id="checkoutdate" value="11.10.2018" name="checkoutdate" type="text" placeholder="06.10.2018" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-auto control-label" for="peopleamount">People amount</label>
  <div class="col-md-auto">
  <input id="peopleamount" value="2" name="peopleamount" type="text" placeholder="2" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-auto control-label" for="search"></label>
  <div class="col-md-auto">
    <button id="search" name="search" class="btn btn-success">SEARCH</button>
  </div>
</div>






<br><div><img src="https://www.jetsetter.com/uploads/sites/7/2018/04/Qfs-7a1K.jpeg" class="img-fluid" alt="Responsive image"></div>

</fieldset>
</form>
</body>
</html>



