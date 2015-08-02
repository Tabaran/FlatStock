<%@ tag import="static com.flatstock.controller.ShowReservationsController.*" %>
<%@ tag import="static com.flatstock.controller.ShowApartmentsController.*" %>
<%@ tag import="static com.flatstock.controller.ShowUsersController.*" %>
<a href='<%= USERS_PATH%>'>
    <button type="button" class="btn btn-primary">Users</button>
</a>
<a href='<%= APARTMENTS_PATH%>'>
    <button type="button" class="btn btn-primary">Apartments</button>
</a>
<a href='<%= RESERVATIONS_PATH%>'>
    <button type="button" class="btn btn-primary">Reservations</button>
</a>