<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" method="post" command="do?command=login">
        <fieldset>

       <!-- Form Name -->

       <legend>Login</legend>


       <!-- Text input-->
       <div class="form-group">

         <label class="col-md-4 control-label" for="email">Email</label>
         <div class="col-md-4">

         <input id="email" value="testemail@gmail.ru" name="email" type="text" placeholder="e-mail" class="form-control input-md" required="">
         </div>
       </div>

       <!-- Password input-->
       <div class="form-group">
         <label class="col-md-4 control-label" for="password">Password</label>
         <div class="col-md-4">
           <input id="password" value="testPassword" name="password" type="password" placeholder="password" class="form-control input-md" required="">
           <span class="help-block">* a-zA-Z0-9 (min 6 symbols)</span>
         </div>
       </div>

       <!-- Button -->
       <div class="form-group">
         <label class="col-md-4 control-label" for="loginbutton"></label>
         <div class="col-md-4">
           <button id="loginbutton" name="loginbutton" class="btn btn-primary">SUBMIT</button>
         </div>
       </div>

       </fieldset>
       </form>

</div>
</body>
</html>

