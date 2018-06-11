<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
    <html>
    <%@ include file="include/head.htm" %>

        <body>
            <div class="container">
                <%@ include file="include/menu.htm" %>
                    <form class="form-horizontal" method="post" action="do?command=SignUp">
                        <fieldset>
                            <!-- Form Name -->
                            <legend>SignUp</legend>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nickName">NickName</label>

                                <div class="col-md-4">
                                    <input id="nickName" name="nickName" value="dd" type="text" placeholder="" class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="email">Email</label>

                                <div class="col-md-4">
                                    <input id="email" name="email" type="text" value="dd" placeholder="" class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Password input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="password">Password </label>
                                <div class="col-md-4">
                                    <input id="password" name="password" type="text" value="dd" placeholder="" class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="firstName">FirstName</label>
                                <div class="col-md-4">
                                    <input id="firstName" name="firstName" type="text" placeholder="" value="dd" class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="lastName">LastName</label>
                                <div class="col-md-4">
                                    <input id="lastName" name="lastName" type="text" value="dd" placeholder="" class="form-control input-md" required="">

                                </div>
                            </div>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="middleName">MiddleName</label>
                                <div class="col-md-4">
                                    <input id="middleName" name="middleName" type="text" value="dd" placeholder="" class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="phoneNumber">PhoneNumber</label>
                                <div class="col-md-4">
                                    <input id="phoneNumber" name="phoneNumber" type="text" placeholder="" value="25535472547" class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="SingUp">SignUp</label>
                                <div class="col-md-4">
                                    <button id="SingUp" name="SingUp" class="btn btn-primary">SignUp</button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

            </div>
        </body>

    </html>