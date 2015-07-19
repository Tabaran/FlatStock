<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IReservation"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.flatstock.model.IUser" %>
<%@ page import="com.flatstock.model.IApartment" %>
<%@ page import="static com.flatstock.model.impl.User.*"%>
<%@ page import="static com.flatstock.model.impl.Reservation.*"%>
<%@ page import="static com.flatstock.model.impl.Apartment.*"%>
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
  <%
    List<IReservation> reservations = (List<IReservation>)request.getAttribute(RESERVATIONS);
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    Map<Integer, IUser> usersMap = (Map<Integer, IUser>)request.getAttribute(USERS);
    Map<Integer, IApartment> apartmentsMap = (Map<Integer, IApartment>)request.getAttribute(APARTMENTS);
    IUser user = null;
    IApartment apartment = null;
    for(IReservation reservation: reservations){
      user = usersMap.get(reservation.getUserId());
      apartment = apartmentsMap.get(reservation.getApartmentId());
      out.println("<tr>");
      out.println("<td>" + reservation.getId() + "</td>");
      if(user != null) out.println("<td>" + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ") " + "</td>");
      else out.println("<td> no owner </td>");
      if(apartment != null) out.println("<td>" + apartment.getAddress() + "</td>");
      else out.println("<td> no apartments </td>");
      out.println("<td>" + format.format(reservation.getStartTime()) + "</td>");
      out.println("<td>" + format.format(reservation.getEndTime()) + "</td>");
      out.println("<td><a href='" + REMOVE_RESERVATION_PATH + "?id=" + reservation.getId() + "'><button class='btn'>Remove</button></a></button></td>");
      out.println("<td><a href='" + UPDATE_RESERVATION_PATH + "?id=" + reservation.getId() + "'><button class='btn'>Update</button></a></button></td>");
      out.println("</tr>");
    }
  %>
  </tbody>
</table>
  </div>
  </div>
</div>
</body>
</html>