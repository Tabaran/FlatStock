<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IUser"%>
<%@ page import="static com.flatstock.controller.UpdateUserController.*"%>
<%@ page import="static com.flatstock.controller.RemoveUserController.*"%>
<%@ page import="static com.flatstock.model.impl.User.*"%>

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
        <a href='/addUser.jsp'><button class="btn">Add User</button></a>
    </div>
    <div class="row">
        <table class="table" >
            <thead>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Login</th>
                <th>Password</th>
                <th>Gender</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getLogin()}</td>
                    <td>${user.getPassword()}</td>
                    <td>${user.getGender()}</td>
                    <td><a href="<%= REMOVE_USER_PATH%>?id=${user.getId()}"><button class='btn'>Remove</button></a></td>
                    <td><a href="<%= UPDATE_USER_PATH%>?id=${user.getId()}"><button class='btn'>Update</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>