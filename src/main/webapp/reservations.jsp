<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IReservation"%>


<html>
<a href='/add_reservation'><button>Add Reservation</button></a><br/>
<body>
<table border="1">
  <%
    List<IReservation> reservations = (List<IReservation>)request.getAttribute("reservations");
    for(IReservation reservation: reservations){
      out.println("<tr>");
      out.println("<td>" + reservation.getId() + "</td>");
      out.println("<td>" + reservation.getUserId() + "</td>");
      out.println("<td>" + reservation.getApartmentId() + "</td>");
      out.println("<td>" + reservation.getStartTime() + "</td>");
      out.println("<td>" + reservation.getEndTime() + "</td>");
      out.println("<td><a href='/remove_reservation?id=" + reservation.getId() + "'><button>Remove</button></a></button></td>");
      out.println("<td><a href='/update_reservation?id=" + reservation.getId() + "'><button>Update</button></a></button></td>");
      out.println("</tr>");
    }
  %>
</table>
</body>
</html>