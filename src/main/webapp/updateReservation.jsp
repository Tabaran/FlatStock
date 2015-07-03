<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.flatstock.model.IReservation"%><html>
  <%IReservation reservation = (IReservation)request.getAttribute("reservation");%>
<html>
<head>
  <title></title>
</head>
<body>
<form method="POST" action="/update_reservation">
  <input type="hidden" name="id" value="<%= reservation.getId()%>" />
  <p>Owner: <input type="text" name="user" value="<%= reservation.getUserId()%>"/></p>
  <p>Apartments: <input type="text" name="apartment" value="<%= reservation.getApartmentId()%>"/></p>
  <p>Start Date: <input type="text" name="start" value="<%= reservation.getStartTime()%>"/></p>
  <p>End Date: <input type="text" name="end" value="<%= reservation.getEndTime()%>"/></p>
  <p><input type="submit" value="Submit"/></p>
</form>
</body>
</html>