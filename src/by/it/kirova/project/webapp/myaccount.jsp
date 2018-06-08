<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>



 <form class="form-horizontal" method="post" command="do?command=myaccount">
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

            <div class="row">
             <div class="col-md-6 text-left">
                        <div class="form-group">
                        <div class="col-md-auto">
                        <legend>My account - Edit my account</legend>
                        </div>
                        </div>
                        </div>


             <div class="col-md-6 text-right">
            <div class="form-group">
            <div class="col-md-auto">
            <button id="logout" name="logout"  class="btn btn-light">LOG OUT</button>
            <button id="deletemyaccount" name="deletemyaccount" class="btn btn-default">DELETE MY ACCOUNT</button>
            </div>
            </div>
            </div>
            </div>


           <!-- Text input-->
 <div class="row justify-content-left align-items-start">
                   <div class="col-md-6">
                   <div class="form-group">
                     <label class="col-md-auto control-label" for="email">Email</label>
                     <div class="col-md-auto">
                     <input id="email" value="${email}" name="email" type="text" placeholder="e-mail" class="form-control input-md" required="">

                     </div>
                     </div>
                   </div>

                   <!-- Password input-->
                   <div class="col-md-6">
                   <div class="form-group">
                     <label class="col-md-auto control-label" for="password">Password</label>
                     <div class="col-md-auto">
                       <input id="password" value="${password}" name="password" type="password" placeholder="password" class="form-control input-md" required="">
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
                     <input id="firstname" value="${firstname}" name="firstname" type="text" placeholder="first name" class="form-control input-md" required="">

                     </div>
                     </div>
                   </div>

                   <!-- Text input-->
                   <div class="col-md-6">
                   <div class="form-group">
                     <label class="col-md-auto control-label" for="lastname">Last name</label>
                     <div class="col-md-auto">
                     <input id="lastname" value="${lastname}" name="lastname" type="text" placeholder="last name" class="form-control input-md" required="">

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
                     <input id="middlename" value="${middlename}" name="middlename" type="text" placeholder="middle name" class="form-control input-md">

                     </div>
                     </div>
                   </div>

                   <!-- Text input-->

                   <div class="col-md-6">
                   <div class="form-group">
                     <label class="col-md-auto control-label" for="residencecountry">Residence country</label>
                     <div class="col-md-auto">
                     <input id="residencecountry" value="${residencecountry}" name="residencecountry" type="text" placeholder="residence country" class="form-control input-md" required="">

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
                   <input id="phonenumber" value="${phonenumber}" name="phonenumber" type="text" placeholder="phone number" class="form-control input-md" required="">
                   </div>
                   </div>
                   </div>
                   </div>


            <!-- Button (Double) -->
                     <div class="form-group">
                       <div class="col-md-auto">
                         <button id="saveinfo" name="saveinfo" class="btn btn-success">SAVE INFO</button>
                       </div>
                     </div>
                   </div>


           </fieldset>
           </form>
</div>
</body>
</html>


