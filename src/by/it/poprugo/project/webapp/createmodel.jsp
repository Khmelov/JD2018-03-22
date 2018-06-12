<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=CreateModel">
        <fieldset>

            <!-- Form Name -->
            <legend>Добавление модели</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Model</label>
                <div class="col-md-5">
                    <input id="model" name="model"
                           value="Wardrobe1" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Rooms</label>
                <div class="col-md-2">
                    <input id="name" name="name"
                           value="Ivan" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Address</label>
                <div class="col-md-5">
                    <input id="address"
                           value="Некрасова 88" name="address" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Rooms</label>
                <div class="col-md-2">
                    <input id="phone" name="phone"
                           value="33-525-33" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="number">Rooms</label>
                <div class="col-md-2">
                    <input id="number" name="number"
                           value="W_2018_05_18" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="datacontr">Rooms</label>
                <div class="col-md-2">
                    <input id="datacontr" name="datacontr"
                           value="2018-05-18" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Price</label>
                <div class="col-md-4">
                    <input id="price" name="price"
                           value="800" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="keymoney">Price</label>
                <div class="col-md-4">
                    <input id="keymoney" name="keymoney"
                           value="350" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Добавить модель</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>
