<%@ tag import="static com.flatstock.controller.ReservationsController.*" %>
<%@ tag import="static com.flatstock.controller.ApartmentsController.*" %>
<%@ tag import="static com.flatstock.controller.UsersController.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href='<%= USERS_PATH%>'>
    <button type="button" class="btn btn-primary">Users</button>
</a>
<a href='<%= APARTMENTS_PATH%>'>
    <button type="button" class="btn btn-primary">Apartments</button>
</a>
<a href='<%= RESERVATIONS_PATH%>'>
    <button type="button" class="btn btn-primary">Reservations</button>
</a>
<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input  class="btn" type="submit" value="Sign Out"/>
</form>
Hello ${sessionScope.user.getLogin()}!