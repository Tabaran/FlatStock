<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <c:forEach items="${apartments}" var="apartment">
        <tr>
          <td>${apartment.getId()}</td>
          <td>${apartment.getAddress()}</td>
          <td>${apartment.getPrice()}</td>
          <td>${apartment.getDescription()}</td>
          <td>${apartment.getFloor()}</td>
          <td>${users.get(apartment.getOwnerId()).getFirstName()} ${users.get(apartment.getOwnerId()).getLastName()}</td>
          <td><a href="<%= REMOVE_APARTMENTS_PATH%>?id=${apartment.getId()}"><button class='btn'>Remove</button></a></td>
          <td><a href="<%= UPDATE_APARTMENTS_PATH%>?id=${apartment.getId()}"><button class='btn'>Update</button></a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</div>
</body>
</html>
