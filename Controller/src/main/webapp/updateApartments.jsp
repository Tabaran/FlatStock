<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.controller.apartments.UpdateApartmentsController.*"%>
<%@ page import="static com.flatstock.model.Apartment.*"%>


<html>
<head>
  <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<form method="POST" action="<%= UPDATE_APARTMENTS_PATH%>" class="navbar-form">
    <div class="form-group container">
      <input type="hidden" name="<%= ID%>" value="${apartments.getId()}" />
      <div class="row">
      <div class="col-md-2"> Address:</div>
     <div class="col-md-10"> <input class="form-control" type="text" name="<%= ADDRESS%>" value="${apartments.getAddress()}"/> </div>
      </div>
      <div class="row">
      <div class="col-md-2"> Price: </div>
      <div class="col-md-10"><input class="form-control" type="text" name="<%= PRICE%>" value="${apartments.getPrice()}"/> </div>
      </div>
      <div class="row">
      <div class="col-md-2"> Description: </div>
      <div class="col-md-10"> <input class="form-control" type="text" name="<%= DESCRIPTION%>" value="${apartments.getDescription()}"/> </div>
      </div>
      <div class="row">
      <div class="col-md-2"> Floor: </div>
      <div class="col-md-10"><input class="form-control" type="text" name="<%= FLOOR%>" value="${apartments.getFloor()}"/> </div>
      </div>
      <div class="row">
      <div class="col-md-2"> Room number: </div>
      <div class="col-md-10"> <input class="form-control" type="text" name="<%= ROOM_NUMBER%>" value="${apartments.getRoomNumber()}"/></div>
      </div>
      <div class="row">
      <div class="col-md-2"> Owner:</div>
      <div class="col-md-10">
        <select class="form-control" name="<%= OWNER%>">
            <c:forEach items="${users}" var="user">
                <option value="${user.getId()}"
                        <c:if test="${apartments.getOwnerId() eq user.getId()}">selected</c:if>>
                    ${user.getFirstName()} ${user.getLastName()} (${user.getEmail()})
                </option>
            </c:forEach>
        </select>
      </div>
    </div>
      <div class="row">
      <input  class="btn" type="submit" value="Submit"/>
      </div>
    </div>
</form>
</body>
</html>
