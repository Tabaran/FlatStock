<%@ attribute name="apartments" required="true" type="java.util.List<com.flatstock.model.impl.Apartment>" %>
<%@ attribute name="remove" required="true" rtexprvalue="true" %>
<%@ attribute name="update" required="true" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Adress</th>
        <th>Price</th>
        <th>Description</th>
        <th>Floor</th>
        <th>Owner</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${apartments}" var="apartment">
        <tr>
            <td>${apartment.getId()}</td>
            <td>${apartment.getAddress()}</td>
            <td>${apartment.getPrice()}</td>
            <td>${apartment.getDescription()}</td>
            <td>${apartment.getFloor()}</td>
            <td>${users.get(apartment.getOwnerId()).getFirstName()} ${users.get(apartment.getOwnerId()).getLastName()}</td>
            <td><a href="${remove}?id=${apartment.getId()}"><button class='btn'>Remove</button></a></td>
            <td><a href="${update}?id=${apartment.getId()}"><button class='btn'>Update</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>