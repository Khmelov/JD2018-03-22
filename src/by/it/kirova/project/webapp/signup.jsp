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
                    <a class="nav-link" style="font-size: 14pt;" href="do?command=Login">Login</a>
                </li>
                <li class="nav-item">
            </ul>
        </div>
    </nav>



       <form class="form-horizontal" method="post" command="do?command=signup">
       <fieldset>

       <!-- Form Name -->
       <legend>Sign Up</legend>

                 <div class="row justify-content-left align-items-start">
                  <div class="col-md-6">
                  <div class="form-group">
                    <label class="col-md-auto control-label" for="email">Email</label>
                    <div class="col-md-auto">
                    <input id="email" value="testemail@gmail.ru" name="email" type="text" placeholder="e-mail" class="form-control input-md" required="">

                    </div>
                    </div>
                  </div>

                  <!-- Password input-->
                  <div class="col-md-6">
                  <div class="form-group">
                    <label class="col-md-auto control-label" for="password">Password</label>
                    <div class="col-md-auto">
                      <input id="password" value="testPassword" name="password" type="password" placeholder="password" class="form-control input-md" required="">
                      <span class="help-block">* a-zA-Z0-9 (min 6 symbols)</span>
                    </div>
                  </div>
                  </div>
                  </div>

                  <!-- Text input-->
                  <div class="row justify-content-left align-items-start">
                  <div class="col-md-6">
                  <div class="form-group">
                    <label class="col-md-auto control-label" for="firstname">First name</label>
                    <div class="col-md-auto">
                    <input id="firstname" value="testName" name="firstname" type="text" placeholder="first name" class="form-control input-md" required="">

                    </div>
                    </div>
                  </div>

                  <!-- Text input-->
                  <div class="col-md-6">
                  <div class="form-group">
                    <label class="col-md-auto control-label" for="lastname">Last name</label>
                    <div class="col-md-auto">
                    <input id="lastname" value="testLastName" name="lastname" type="text" placeholder="last name" class="form-control input-md" required="">

                    </div>
                    </div>
                  </div>
                  </div>

                  <!-- Text input-->
                  <div class="row justify-content-left align-items-start">
                  <div class="col-md-6">
                  <div class="form-group">
                    <label class="col-md-auto control-label" for="middlename">Middle name</label>
                    <div class="col-md-auto">
                    <input id="middlename" value="" name="middlename" type="text" placeholder="middle name" class="form-control input-md">

                    </div>
                    </div>
                  </div>

                  <!-- Text input-->

                  <div class="col-md-6">
                  <div class="form-group">
                    <label class="col-md-auto control-label" for="residencecountry">Residence country</label>
                    <div class="col-md-auto">
                    <input id="residencecountry" value="testCountry" name="residencecountry" type="text" placeholder="residence country" class="form-control input-md" required="">

                    </div>
                    </div>
                    </div>
                    </div>

                      <!-- Text input-->
                       <div class="row justify-content-left align-items-start">
                  <div class="col-md-6">
                  <div class="form-group">
                  <label class="col-md-auto control-label" for="phonenumber">Phone number</label>
                  <div class="col-md-auto">
                  <input id="phonenumber" value="+37529 1111111" name="phonenumber" type="text" placeholder="phone number" class="form-control input-md" required="">
                  </div>
                  </div>
                  </div>
                  </div>

       <!-- Button -->
       <div class="form-group">
         <label class="col-md-4 control-label" for="singupbutton"></label>
         <div class="col-md-4">
           <button id="singupbutton" name="singupbutton" class="btn btn-success">SIGN UP</button>
         </div>
       </div>

       </fieldset>
       </form>


</div>
</body>
</html>




