<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>



 <form class="form-horizontal" method="post" command="do?command=myproperty">
           <fieldset>
              <!-- Form Name -->


<div class="row justify-content-left align-items-start">
 <div class="col-md-2">
    <ul class="nav navbar-nav nav-pills nav-stacked">
        <li class="active nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=MyProperty">Add new property</a>
        </li>

        <li class="nav-item">
        <a class="nav-link" style="font-size: 14pt; color: #949494;" href="do?command=EditMyProperty">Edit my property</a>
        </li>
    </ul>

    </div>





          <div class="col-md-10">
          <form class="form-horizontal">

<div class="row justify-content-left align-items-start">
 <div class="col-md-12">
<div class="form-group">
  <div class="col-md-auto">
  <legend>My property - Add new property</legend>
  </div>
  </div>
  </div>
</div>



          <!-- Text input-->
          <div class="row justify-content-left align-items-start">
          <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="hotelname">Hotel name</label>
            <div class="col-md-auto">
            <input id="hotelname" name="hotelname" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
          </div>

          <!-- Text input-->
          <div class="col-md-3">
          <div class="form-group">
            <label class="col-md-auto control-label" for="hoteltype">Hotel type</label>
            <div class="col-md-auto">
            <input id="hoteltype" name="hoteltype" type="text" placeholder="" class="form-control input-md" required="">
            <span class="help-block">*Hotel, Appartment, etc.</span>
            </div>
            </div>
          </div>

          <!-- Text input-->
          <div class="col-md-3">
          <div class="form-group">
            <label class="col-md-auto control-label" for="starrating">Star rating</label>
            <div class="col-md-auto">
            <input id="starrating" name="starrating" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
            </div>
          </div>

          <!-- Text input-->
          <div class="row justify-content-left align-items-start">
           <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="country">Country</label>
            <div class="col-md-auto">
            <input id="country" name="country" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
          </div>

          <!-- Text input-->
           <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="city">City</label>
            <div class="col-md-auto">
            <input id="city" name="city" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
            </div>
          </div>

          <!-- Text input-->
           <div class="row justify-content-left align-items-start">
           <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="street">Street</label>
            <div class="col-md-auto">
            <input id="street" name="street" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
          </div>

          <!-- Text input-->
           <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="housenumber">House number</label>
            <div class="col-md-auto">
            <input id="housenumber" name="housenumber" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
            </div>
          </div>

          <!-- Text input-->
          <div class="row justify-content-left align-items-start">
          <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="email">Contact E-mail</label>
            <div class="col-md-auto">
            <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">

            </div>
            </div>
          </div>

          <!-- Text input-->
          <div class="col-md-6">
          <div class="form-group">
            <label class="col-md-auto control-label" for="contactphone">Contact phone number</label>
            <div class="col-md-auto">
            <input id="contactphone" name="contactphone" type="text" placeholder="" class="form-control input-md" required="">
            <span class="help-block">*format: +37529 1111111</span>
            </div>
            </div>
            </div>
          </div>

          <!-- Button (Double) -->
          <div class="form-group">

            <div class="col-md-auto text-right">
              <button id="addproperty" name="addproperty" class="btn btn-default">ADD PROPERTY</button>
            </div>
          </div>

          </fieldset>
          </form>

</div>
</body>
</html>


