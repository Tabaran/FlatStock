<%@ page import="com.flatstock.model.IUser"%>
<%@ page import="com.flatstock.model.Gender"%>
<%@ page import="static com.flatstock.controller.UpdateUserController.*"%>
<%@ page import="static com.flatstock.model.impl.User.*"%>
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
<%IUser user = (IUser)request.getAttribute(USER);%>

<body>
<form method="POST" action="<%= UPDATE_USER_PATH%>" class="navbar-form">
    <input type="hidden" name="id" value="<%= user.getId()%>" />

    <div class="container form-group">
        <div class="row">
            <div class="col-md-2">
                First Name:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= FIRST_NAME%>" value="<%= user.getFirstName()%>"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Last Name:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= LAST_NAME%>" value="<%= user.getLastName()%>"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Email:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="email" name="<%= EMAIL%>" value="<%= user.getEmail()%>"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Login:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= LOGIN%>" value="<%= user.getLogin()%>"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Password:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="password" name="<%= PASSWORD%>" value="<%= user.getPassword()%>"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Gender:
            </div>
            <div class="col-md-10">
                male <input type="radio" name="<%= GENDER%>" value="<%= Gender.MALE.toString()%>" <%if(user.getGender().equals(Gender.MALE)) out.print("checked"); %>/>
                female <input type="radio" name="<%= GENDER%>" value="<%= Gender.FEMALE.toString()%>" <%if(user.getGender().equals(Gender.FEMALE)) out.print("checked"); %>/>
            </div>
        </div>
        <div class="row">
            <input  class="btn" type="submit" value="Submit"/>
        </div>
    </div>
</form>
</body>
</html>