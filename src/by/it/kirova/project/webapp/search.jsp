<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
 <%@ include file="include/menu.htm" %>



 <form class="form-horizontal" method="post" command="do?command=search">
           <fieldset>
              <!-- Form Name -->
                      <legend>Search result:</legend>

<div class="row justify-content-left align-items-start">
<div class="col-md-12">
<p>${str}</p>
</div>
</div>


          </fieldset>
          </form>

</div>
</body>
</html>


