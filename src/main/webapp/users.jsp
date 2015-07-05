<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IUser"%>


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
            <%
                List<IUser> users = (List<IUser>)request.getAttribute("users");
                for(IUser user: users){
                    out.println("<tr>");
                    out.println("<td>" + user.getId() + "</td>");
                    out.println("<td>" + user.getFirstName() + "</td>");
                    out.println("<td>" + user.getLastName() + "</td>");
                    out.println("<td>" + user.getEmail() + "</td>");
                    out.println("<td>" + user.getLogin() + "</td>");
                    out.println("<td>" + user.getPassword() + "</td>");
                    out.println("<td>" + user.getGender() + "</td>");
                    out.println("<td><a href='/remove_user?id=" + user.getId() + "'><button class='btn'>Remove</button></a></button></td>");
                    out.println("<td><a href='/update_user?id=" + user.getId() + "'><button class='btn'>Update</button></a></button></td>");
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