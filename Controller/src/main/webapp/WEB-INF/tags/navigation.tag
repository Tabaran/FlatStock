<%@ tag import="static com.flatstock.controller.ReservationsController.*" %>
<%@ tag import="static com.flatstock.controller.ApartmentsController.*" %>
<%@ tag import="static com.flatstock.controller.UsersController.*" %>

<a href='<%= USERS_PATH%>'>
    <button type="button" class="btn btn-primary">Users</button>
</a>
<a href='<%= APARTMENTS_PATH%>'>
    <button type="button" class="btn btn-primary">Apartments</button>
</a>
<a href='<%= RESERVATIONS_PATH%>'>
    <button type="button" class="btn btn-primary">Reservations</button>
</a>

Hello ${sessionScope.user.getFirstName()}!