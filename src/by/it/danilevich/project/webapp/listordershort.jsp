 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

    <div class="row">
       <table class="table">
        <thead>
          <tr>
            <th>id</th>
            <th>Дата</th>
            <th>Заказчик</th>
            <th>Адрес</th>
            <th>Услуга</th>
            <th>Количество</th>
            <th>Ед.изм.</th>
            <th>Стоимость</th>
            <th>Исполнитель</th>
            <th>Статус</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${listOrder}" var="order">
            <tr>
              <td>${order.id}</td>
              <td>${order.dateString}</td>
              <td>${order.nameClient}</td>
              <td>${order.address}</td>
              <td>${order.nameWork}</td>
              <td>${order.amount}</td>
              <td>${order.unitWork}</td>
              <td>${order.totalMoney}</td>
              <td>${order.nameExecutor}</td>
              <td>${order.status}</td>
             </tr>
            </c:forEach>
        </tbody>
      </table>
    </div>
