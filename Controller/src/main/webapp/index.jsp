<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.controller.ShowReservationsController.*"%>
<%@ page import="static com.flatstock.controller.ShowApartmentsController.*"%>
<%@ page import="static com.flatstock.controller.ShowUsersController.*"%>
<html>
<head>
    <title>Flat Stock</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
<div class="navbar-form">
  <div class="form-group container">
    <div class="row">
  <a href='<%= USERS_PATH%>'><button type="button" class="btn btn-primary">Users</button></a>
  <a href='<%= APARTMENTS_PATH%>'><button type="button" class="btn btn-primary">Apartments</button></a>
  <a href='<%= RESERVATIONS_PATH%>'><button type="button" class="btn btn-primary">Reservations</button></a>
</div>
    </div>
  </div>

  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>

</body>
</html>
