<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=CreateAd">
        <fieldset>

            <!-- Form Name -->
            <legend>Добавление объявления</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Description</label>
                <div class="col-md-5">
                    <input id="description" name="description"
                           value="Good Room" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="rooms">Rooms</label>
                <div class="col-md-2">
                    <input id="rooms" name="rooms"
                           value="2" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <input id="price" name="price"
                           value="55555" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="area">Area</label>
                <div class="col-md-4">
                    <input id="area" name="area"
                           value="50" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flats">Flats</label>
                <div class="col-md-4">
                    <input id="flats" name="flats"
                           value="9" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="flat">Flat</label>
                <div class="col-md-4">
                    <input id="flat" name="flat"
                           value="8" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Address</label>
                <div class="col-md-5">
                    <input id="address"
                           value="Некрасова 99" name="address" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Добавить объявление</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>
