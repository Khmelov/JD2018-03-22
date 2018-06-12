<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=signup">
        <fieldset>

            <!-- Form Name -->
            <legend>Signup</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="TestLogin" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">Input your login</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="testemail@mail.ru" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">your e-mail</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">a-zA-Z0-9 min 5 symbols</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signupbutton"></label>
                <div class="col-md-4">
                    <button id="signupbutton" name="signupbutton" class="btn btn-success">Submit</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>




