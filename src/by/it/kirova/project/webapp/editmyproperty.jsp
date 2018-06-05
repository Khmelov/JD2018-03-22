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



 <form class="form-horizontal" method="post" command="do?command=editmyproperty">
           <fieldset>
              <!-- Form Name -->
                      <legend>My property - Edit my property</legend>

<div class="row justify-content-left align-items-start">
 <div class="col-md-2">
    <ul class="nav navbar-nav nav-pills nav-stacked">
        <li class="nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyProperty">Add new property</a>
        </li>

        <li class="active nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=EditMyProperty">Edit my property</a>
        </li>

         <li class="nav-item">
         <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=Reservations">Reservations</a>
         </li>

    </ul>

    </div>





          <div class="col-md-10">
          <form class="form-horizontal">

         <!-- Form Name -->

         <!-- Text input-->
         <div class="row justify-content-left align-items-end">
          <div class="col-md-3">
         <div class="form-group">
           <label class="col-md-auto control-label" for="city">City</label>
           <div class="col-md-auto">
           <input id="city" name="city" readonly type="text" placeholder="London" class="form-control input-md" required="">

           </div>
           </div>
         </div>

         <!-- Text input-->
          <div class="col-md-5">
         <div class="form-group">
           <label class="col-md-auto control-label" for="hotelname">Hotel name</label>
           <div class="col-md-auto">
           <input id="hotelname" name="hotelname" readonly type="text" placeholder="Resort &amp; Spa" class="form-control input-md" required="">

           </div>
           </div>
         </div>

         <!-- Button (Double) -->
          <div class="col-md-4">
         <div class="form-group">
           <label class="col-md-auto control-label" for="edithoteldata"></label>
           <div class="col-md-auto">
             <button id="edithoteldata" name="edithoteldata" class="btn btn-success">EDIT INFO</button>
             <button id="deletehotel" name="deletehotel" class="btn btn-danger">DELETE HOTEL</button>
           </div>
         </div>

         </fieldset>
         </form>


</div>
</body>
</html>


