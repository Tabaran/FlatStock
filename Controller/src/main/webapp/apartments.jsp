<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IApartment"%>
<%@ page import="com.flatstock.model.IUser" %>
<%@ page import="static com.flatstock.model.impl.Apartment.*" %>
<%@ page import="static com.flatstock.model.impl.User.*" %>
<%@ page import="static com.flatstock.controller.AddApartmentsController.*" %>
<%@ page import="static com.flatstock.controller.RemoveApartmentsController.*" %>
<%@ page import="static com.flatstock.controller.UpdateApartmentsController.*" %>
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
    <a href='<%= ADD_APARTMENTS_PATH%>'><button class='btn'>Add Apartments</button></a>
  </div>
  <div class="row">
    <table class="table" >
      <thead>
      <tr>
        <th>Id</th>
        <th>Adress</th>
        <th>Price</th>
        <th>Description</th>
        <th>Floor</th>
        <th>Owner</th>
        <th colspan="2"></th>
      </tr>
      </thead>
      <tbody>
      <%
        List<IApartment> apartments = (List<IApartment>)request.getAttribute(APARTMENTS);
        Map<Integer, IUser> usersMap = (Map<Integer, IUser>)request.getAttribute(USERS);
        IUser owner = null;
        for(IApartment apartment: apartments){
          owner = usersMap.get(apartment.getOwnerId());
          out.println("<tr>");
          out.println("<td>" + apartment.getId() + "</td>");
          out.println("<td>" + apartment.getAddress() + "</td>");
          out.println("<td>" + apartment.getPrice() + "</td>");
          out.println("<td>" + apartment.getDescription() + "</td>");
          out.println("<td>" + apartment.getFloor() + "</td>");
          if(owner != null) out.println("<td>" + owner.getFirstName() + " " + owner.getLastName() + " (" + owner.getEmail() + ") " + "</td>");
          else out.println("<td> no owner </td>");
          out.println("<td><a href='" + REMOVE_APARTMENTS_PATH + "?id=" + apartment.getId() + "'><button class='btn'>Remove</button></a></button></td>");
          out.println("<td><a href='" + UPDATE_APARTMENTS_PATH + "?id=" + apartment.getId() + "'><button class='btn'>Update</button></a></button></td>");
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
