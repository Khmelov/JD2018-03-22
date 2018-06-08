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
<div class="form-group">
  <p>${listUserReservations}</p>
    </div>
    </div>
    </div>

           </div>


           </fieldset>
           </form>
</div>
</body>
</html>


