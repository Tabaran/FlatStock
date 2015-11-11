<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ page import="static com.flatstock.controller.ReservationsController.*"%>

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
    <h:navigation/>
  </div>
  <div class="row">
    <h:reservations_list reservations="${reservations}" remove="<%= REMOVE_RESERVATION_PATH%>" update="<%= UPDATE_RESERVATION_PATH%>"/>
  </div>
  <div class="row">
    <a href='<%= ADD_RESERVATION_PATH%>'><button class="btn">Add Reservation</button></a>
  </div>
  </div>
</div>
</body>
</html>