<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static com.flatstock.model.impl.User.*"%>
<%@ page import="static com.flatstock.controller.users.UpdateUserController.*"%>
<%@ page import="static com.flatstock.controller.PhotoController.*"%>
<%@ page import="com.flatstock.model.Role" %>

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
<form method="POST" action="<%= UPDATE_USER_PATH%>" class="navbar-form" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${user.getId()}"/>
    <div class="container form-group">
        <div class="row">
            <div class="col-md-2">
                First Name:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= FIRST_NAME%>" value="${user.getFirstName()}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Last Name:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= LAST_NAME%>" value="${user.getLastName()}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Email:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="email" name="<%= EMAIL%>" value="${user.getEmail()}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Login:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="text" name="<%= LOGIN%>" value="${user.getLogin()}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Password:
            </div>
            <div class="col-md-10">
                <input class="form-control" type="password" name="<%= PASSWORD%>" value="${user.getPassword()}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2"> Role:</div>
            <div class="col-md-10">
                <select class="form-control" name="<%= ROLE%>">
                    <c:forEach items="<%= Role.values()%>" var="role">
                        <option value="${role.toString()}"
                                <c:if test="${user.getRole() eq role}">selected</c:if>>
                                ${role.toString()}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Gender:
            </div>
            <div class="col-md-10">
                male <input type="radio" name="<%= GENDER%>" value="MALE"
                            <c:if test="${user.getGender().toString() eq 'male'}">checked</c:if> />
                female <input type="radio" name="<%= GENDER%>" value="FEMALE"
                              <c:if test="${user.getGender().toString() eq 'female'}">checked</c:if> />
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                Photo:
            </div>
            <div class="col-md-10">
                <img src="<%= GET_PHOTO_PATH%>?<%= PHOTO%>=${user.getPhotoUrl()}&id=${user.getId()}"/>
                <input type="file" name="<%= PHOTO_URL%>" accept="image/*"/>
            </div>
        </div>
        <div class="row">
            <input  class="btn" type="submit" value="Submit"/>
        </div>
    </div>
</form>
</body>
</html>