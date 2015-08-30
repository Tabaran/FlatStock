<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.model.impl.User.*"%>
<%@ page import="static com.flatstock.controller.LoginController.*"%>
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
</head>
<body>
<form method="POST" action="<%= LOGIN_PATH%>" class="navbar-form">
    <div class="container form-group">
        <div class="row">
            <div class="col-md-2">
                Login:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= LOGIN%>"/>
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
            <input  class="btn" type="submit" value="Login"/>
        </div>
    </div>
</form>
</body>
</html>
