<%@ page import="com.flatstock.model.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.controller.AccessController.*" %>
<%@ page import="static com.flatstock.controller.AddUrlController.*" %>
<html>
<head>
    <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
</head>
<body>
<div class="navbar-form">
<div class="form-group container">
  <div class="row">
    <h:navigation/>
  </div>
  <div class="row">
    <input  class="btn" type="submit" form="edit" value="Save"/>
  </div>
  <div class="row">
    <form method="post" id="edit" action="<%= ACCESS_PATH%>"></form>
    <form method="post" id="add" action="<%= ADD_URL_PATH%>"></form>
    <table class="table" >
      <thead>
      <tr>
        <th>Access URL</th>
        <c:forEach items="<%= Role.values()%>" var="role">
          <th>${role.toString()}</th>
        </c:forEach>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${accessMap.keySet()}" var="url">
        <tr>
          <td>${url}</td>
          <c:forEach items="<%= Role.values()%>" var="role">
            <td><input type="checkbox" name="${url}" value="${role.toString()}" form="edit"
                    <c:if test="${accessMap.get(url).contains(role)}">checked</c:if>/></td>
          </c:forEach>
        </tr>
      </c:forEach>
      </tbody>
      </table>
  </div>
    <div class="row">
        Add URL:
        <input type="text" name="<%= URL%>" form="add"/>
        <input  class="btn" type="submit" form="add" value="Add"/>
    </div>

</div>
</div>
</body>
</html>
