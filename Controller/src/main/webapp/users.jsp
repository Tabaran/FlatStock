<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static com.flatstock.controller.users.UsersController.*"%>
<%@ page import="static com.flatstock.controller.users.UsersController.*"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
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
        <h:navigation/>
    </div>
    <div class="row">
        <h:users_list users='${users}' remove='<%= REMOVE_USER_PATH%>' update='<%= UPDATE_USER_PATH%>'/>
    </div>
    <div class="row">
        <a href='/addUser.jsp'><button class="btn">Add User</button></a>
    </div>
</div>
</div>
</body>
</html>