<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal">
    <fieldset>

    <spam>You can to see myself progress </spam>

   <div class="progress">
     <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">Количество просмотров</div>
   </div>
   <div class="progress">
     <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">Количество просмотров за сегодня</div>
   </div>
   <div class="progress">
     <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">Количество предложений покупки</div>
   </div>
   <div class="progress">
     <div class="progress-bar bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Количество предложений обмена</div>
   </div>

    </fieldset>
    </form>

</div>
</body>
</html>

