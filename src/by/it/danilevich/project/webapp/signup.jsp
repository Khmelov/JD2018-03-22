<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=signup">
        <fieldset>

            <!-- Form Name -->
            <legend>Регистрация</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="TestLogin" type="text" placeholder="" class="form-control input-md" required="">
                </div>
            </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="password">Пароль</label>
                            <div class="col-md-4">
                                <input id="password" name="password" value="TestPassword" type="password" placeholder="" class="form-control input-md" required="">
                                <span class="help-block">(минимум 5 символов)</span>
                            </div>
                        </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Введите ваше имя</label>
                <div class="col-md-4">
                    <input id="name" name="name" value="" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"></span>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Введите ваш адрес</label>
                <div class="col-md-4">
                    <input id="address" name="address" value="" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"></span>
                </div>
            </div>

           <div class="form-group">
                <label class="col-md-4 control-label" for="telephone">Введите ваше телефон</label>
                <div class="col-md-4">
                    <input id="telephone" name="telephone" value="" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"></span>
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




