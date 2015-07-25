<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="static com.flatstock.controller.RemoveReservationController.*"%>
<%@ page import="static com.flatstock.controller.UpdateReservationController.*"%>
<%@ page import="static com.flatstock.controller.AddReservationController.*"%>

<html>
<head>
  <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</head>

<body>
<div class="navbar-form">
<div class="form-group container">
  <div class="row">
<a href='<%= ADD_RESERVATION_PATH%>'><button  class="btn" >Add Reservation</button></a>
  </div>
  <div class="row">
<table class="table" >
  <thead>
  <tr>
    <th>Id</th>
    <th>User</th>
    <th>Apartments</th>
    <th>StartTime</th>
    <th>EndTime</th>
    <th colspan="2"></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${reservations}" var="reservation">
    <c:set var="user" value="${users.get(reservation.getUserId())}"/>
    <tr>
      <td>${reservation.getId()}</td>
      <td>${user.getFirstName()} ${user.getLastName()}</td>
      <td>${apartments.get(reservation.getApartmentId()).getAddress()}</td>
      <td><fmt:formatDate pattern="MM/dd/yyyy" value="${reservation.getStartTime()}"/></td>
      <td><fmt:formatDate pattern="MM/dd/yyyy" value="${reservation.getEndTime()}"/></td>
      <td><a href="<%= REMOVE_RESERVATION_PATH%>?id=${reservation.getId()}"><button class='btn'>Remove</button></a></td>
      <td><a href="<%= UPDATE_RESERVATION_PATH%>?id=${reservation.getId()}"><button class='btn'>Update</button></a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
  </div>
  </div>
</div>
</body>
</html>