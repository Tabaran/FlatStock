<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.flatstock.model.IUser"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<form method="POST" action="/add_apartments" class="navbar-form">
  <div class="form-group container">
    <div class="row">
      <div class="col-md-2"> Address:</div>
      <div class="col-md-10"> <input class="form-control" type="text" name="address"/></div>
    </div>
    <div class="row">
      <div class="col-md-2"> Price:</div>
      <div class="col-md-10"> <input class="form-control" type="text" name="price"/></div>
    </div>
    <div class="row">
      <div class="col-md-2"> Description:</div>
      <div class="col-md-10"><input class="form-control" type="text" name="desc"/></div>
    </div>
    <div class="row">
      <div class="col-md-2"> Floor:</div>
      <div class="col-md-10"> <input class="form-control" type="text" name="floor"/></div>
    </div>
    <div class="row">
      <div class="col-md-2"> Room number:</div>
      <div class="col-md-10"> <input class="form-control" type="text" name="rooms"/></div>
    </div>
    <div class="row">
      <div class="col-md-2"> Owner:</div>
      <div class="col-md-10">
        <select class="form-control" name="owner">
          <%
            List<IUser> users = (List<IUser>)request.getAttribute("users");
            for(IUser user: users){
              out.print("<option value=" + user.getId() + ">" +
                      user.getFirstName() + " " + user.getLastName() + " (" +
                      user.getEmail() + ")</option>"
              );
            }
          %>
        </select>
      </div>
    </div>
    <div class="row">
      <input  class="btn" type="submit" value="Submit"/>
    </div>
  </div>

</form>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>

</body>
</html>
