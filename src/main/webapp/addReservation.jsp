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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
    $(function() {
      $( "#from" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        onClose: function( selectedDate ) {
          $( "#to" ).datepicker( "option", "minDate", selectedDate );
        }
      });
      $( "#to" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        onClose: function( selectedDate ) {
          $( "#from" ).datepicker( "option", "maxDate", selectedDate );
        }
      });
    });
  </script>
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
        <input class="form-control" type="text" id="from" name="start" placeholder="mm/dd/yyyy" readonly>
      </div>

    </div>
    <div class="row">
      <div class='col-md-2'>
        End date:
      </div>
      <div class="col-md-10">
        <input class="form-control" type="text" id="to" name="end" placeholder="mm/dd/yyyy" readonly>
      </div>

    </div>
    <div class="row">
      <input  class="btn" type="submit" value="Submit"/>
    </div>
  </div>
</form>


</body>
</html>