<%@ attribute name="reservations" required="true" type="java.util.List<com.flatstock.model.impl.Reservation>" %>
<%@ attribute name="remove" required="true" rtexprvalue="true"%>
<%@ attribute name="update" required="true" rtexprvalue="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="table" >
    <thead>
    <tr>
        <th>Id</th>
        <th>User</th>
        <th>Apartments</th>
        <th>StartTime</th>
        <th>EndTime</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reservations}" var="reservation">
        <c:set var="user" value="${users.get(reservation.getUserId())}"/>
        <tr>
            <td>${reservation.getId()}</td>
            <td>${user.getFirstName()} ${user.getLastName()}</td>
            <td>${apartments.get(reservation.getApartmentId()).getAddress()}</td>
            <td><fmt:formatDate pattern="MM/dd/yyyy" value="${reservation.getStartTime()}"/></td>
            <td><fmt:formatDate pattern="MM/dd/yyyy" value="${reservation.getEndTime()}"/></td>
            <td><a href="${remove}?id=${reservation.getId()}"><button class='btn'>Remove</button></a></td>
            <td><a href="${update}?id=${reservation.getId()}"><button class='btn'>Update</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



