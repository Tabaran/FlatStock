<%@ page import="com.flatstock.model.IUser" %>
<%@ page import="java.util.List" %>
<%@ page import="com.flatstock.model.IApartment" %>
<html>
<head>
  <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
 </head>
<body>
<form method="POST" action="/add_reservation" class="navbar-form">
  <div class="form-group container">
    <div class="row">
      <div class="col-md-2">User: </div>
      <div class="col-md-10">
        <select class="form-control" name="owner">
          <%
            List<IUser> users = (List<IUser>)request.getAttribute("users");
            for(IUser user: users){
              out.print("<option value=" + user.getId() + ">" + user.getFirstName() + " " + user.getLastName() +
                              " (" + user.getEmail() + ")</option>"
              );
            }
          %>
        </select>
      </div>
    </div>
    <div class="row">
      <div class="col-md-2">Apartments: </div>
      <div class="col-md-10">
        <select class="form-control" name="apartment">
          <%
            List<IApartment> apartments = (List<IApartment>)request.getAttribute("apartments");
            for(IApartment apartment: apartments){
              out.print("<option value=" + apartment.getId() + ">" + apartment.getAddress() + ")</option>"
              );
            }
          %>
        </select>
      </div>
    </div>
    <div class="row">
      <div class='col-md-2'>
        Start date:
      </div>
      <div class="col-md-10">
        <input type="text" name="start" placeholder="dd.MM.yyyy">
      </div>

    </div>
    <div class="row">
      <div class='col-md-2'>
        End date:
      </div>
      <div class="col-md-10">
        <input type="text" name="end" placeholder="dd.MM.yyyy">
      </div>

    </div>
    <div class="row">
      <input type="submit" value="Submit"/>
    </div>
  </div>
</form>
</body>
</html>