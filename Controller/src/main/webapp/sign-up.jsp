<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.controller.UsersController.*"%>
<%@ page import="static com.flatstock.model.User.*"%>
<html>
<head>
    <title>Sign up</title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='../main.css'>
</head>
<body>
<form method="POST" action="<%= SIGN_UP_PATH%>" class="navbar-form">
  <div class="row">
    <div class="col-md-2">
      First Name:
    </div>
    <div class="col-md-10">
      <input class="form-control" type="text" name="<%= FIRST_NAME%>"/>
    </div>
  </div>
  <div class="row">
    <div class="col-md-2">
      Last Name:
    </div>
    <div class="col-md-10">
      <input class="form-control" type="text" name="<%= LAST_NAME%>"/>
    </div>
  </div>
  <div class="row">
    <div class="col-md-2">
      Email:
    </div>
    <div class="col-md-10">
      <input class="form-control" type="text" name="<%= EMAIL%>"/>
    </div>
  </div>
  <div class="row">
    <div class="col-md-2">
      Password:
    </div>
    <div class="col-md-10">
      <input class="form-control" type="password" name="<%= PASSWORD%>"/>
    </div>
  </div>
  <div class="row">
    <div class="col-md-2">
      Retype Password:
    </div>
    <div class="col-md-10">
      <input class="form-control" type="password" name="<%= PASSWORD%>"/>
    </div>
  </div>
  <div class="row">
    <input  class="btn" type="submit" value="Sign Up"/>
  </div>
</form>
</body>
</html>
