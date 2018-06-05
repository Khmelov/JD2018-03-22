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
                   <a class="nav-link" style="font-size: 14pt;" href="do?command=SignUp">Sign-up</a>
               </li>
           </ul>
       </div>
   </nav>
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
           <span class="help-block">* a-zA-Z0-9 (min 5 symbols)</span>
         </div>
       </div>

       <!-- Button -->
       <div class="form-group">
         <label class="col-md-4 control-label" for="loginbutton"></label>
         <div class="col-md-4">
           <button id="loginbutton" name="loginbutton" class="btn btn-success">SUBMIT</button>
         </div>
       </div>

       </fieldset>
       </form>

</div>
</body>
</html>

