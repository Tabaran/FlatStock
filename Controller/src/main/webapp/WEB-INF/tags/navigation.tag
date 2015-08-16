<%@ tag import="static com.flatstock.controller.reservations.ShowReservationsController.*" %>
<%@ tag import="static com.flatstock.controller.apartments.ShowApartmentsController.*" %>
<%@ tag import="static com.flatstock.controller.users.ShowUsersController.*" %>
<%@ tag import="static com.flatstock.controller.AccessController.*" %>

<a href='<%= USERS_PATH%>'>
    <button type="button" class="btn btn-primary">Users</button>
</a>
<a href='<%= APARTMENTS_PATH%>'>
    <button type="button" class="btn btn-primary">Apartments</button>
</a>
<a href='<%= RESERVATIONS_PATH%>'>
    <button type="button" class="btn btn-primary">Reservations</button>
</a>
<a href='<%= ACCESS_PATH%>'>
    <button type="button" class="btn btn-primary">Access</button>
</a>
Hello ${sessionScope.user.getFirstName()}!