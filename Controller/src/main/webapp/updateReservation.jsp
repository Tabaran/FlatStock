<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.flatstock.model.IReservation"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="static com.flatstock.model.impl.User.*"%>
<%@ page import="static com.flatstock.model.impl.Reservation.*"%>
<%@ page import="static com.flatstock.controller.UpdateReservationController.*"%>
<html>
 <%IReservation reservation = (IReservation)request.getAttribute(RESERVATIONS);%>
<html>
<head>
  <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
    $(function() {
      $( "#from" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        onClose: function( selectedDate ) {
          $( "#to" ).datepicker( "option", "minDate", selectedDate );
        }
      });
      $( "#to" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        onClose: function( selectedDate ) {
          $( "#from" ).datepicker( "option", "maxDate", selectedDate );
        }
      });
    });
  </script>
</head>
<body>
<form method="POST" action="<%= UPDATE_RESERVATION_PATH%>" class="navbar-form">
  <div class="form-group container">
  <input type="hidden" name="<%= ID%>" value="${reservations.getId()}" />
    <div class="row">
      <div class="col-md-2">User: </div>
      <div class="col-md-10">
        <select class="form-control" name="<%= USER_ID%>">
          <c:forEach items="${users}" var="user">
            <option value="${user.getId()}" <c:if test="${reservations.getUserId() eq user.getId()}">selected</c:if>>${user.getFirstName()} ${user.getLastName()} (${user.getEmail()})</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="row">
      <div class="col-md-2">Apartments: </div>
      <div class="col-md-10">
        <select class="form-control" name="<%= APARTMENT_ID%>">
          <c:forEach items="${apartments}" var="apartment">
            <option value="${apartment.getId()}" <c:if test="${reservations.getApartmentId() eq apartment.getId()}">selected</c:if>>${apartment.getAddress()}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="row">
      <div class='col-md-2'>
        Start date:
      </div>
      <div class="col-md-10">
        <input class="form-control" type="text" id="from" name="<%= START_TIME%>" placeholder="MM.dd.yyyy" value="<%= (new SimpleDateFormat("MM/dd/yyyy")).format(reservation.getStartTime())%>">
      </div>
      </div>
      <div class="row">
      <div class='col-md-2'>
        End date:
      </div>
      <div class="col-md-10">
        <input class="form-control" type="text" id="to" name="<%= END_TIME%>" placeholder="MM.dd.yyyy" value="<%= (new SimpleDateFormat("MM/dd/yyyy")).format(reservation.getEndTime())%>">
      </div>
    </div>
    <div class="row">
      <input  class="btn" type="submit" value="Submit"/>
    </div>
  </div>

</form>
</body>
</html>