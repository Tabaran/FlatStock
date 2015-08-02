<%@ attribute name="users" required="true" type="java.util.List<com.flatstock.model.impl.User>" %>
<%@ attribute name="remove" required="true" rtexprvalue="true" %>
<%@ attribute name="update" required="true" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table">
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
            <td><a href="${remove}?id=${user.getId()}"><button class='btn'>Remove</button></a></td>
            <td><a href="${update}?id=${user.getId()}"><button class='btn'>Update</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


