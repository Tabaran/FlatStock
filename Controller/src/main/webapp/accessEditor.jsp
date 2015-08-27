<%@ page import="com.flatstock.model.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.controller.AccessEditorController.*" %>
<html>
<head>
    <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='style.css'>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<div class="navbar-form">
<div class="form-group container">
  <div class="row">
    <h:navigation/>
  </div>
  <c:if test="${isSaved}">
    <div id="save" class="saved">
      Saved
    </div>
  </c:if>
  <form method="post" action="<%= ACCESS_PATH%>">
  <div class="row">
    <table class="table" >
      <thead>
      <tr>
        <th>Features</th>
        <c:forEach items="<%= Role.values()%>" var="role">
          <th>${role.toString()}</th>
        </c:forEach>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${accessMap.keySet()}" var="groupId">
        <tr>
          <td>${groups.get(groupId).getName()}</td>
          <c:forEach items="<%= Role.values()%>" var="role">
            <td><input type="checkbox" name="${groupId.toString()}" value="${role.toString()}"
                    <c:if test="${accessMap.get(groupId).contains(role)}">checked</c:if>/></td>
          </c:forEach>
        </tr>
      </c:forEach>
      </tbody>
      </table>
  </div>
  <div class="row">
      <input  class="btn" type="submit" value="Save"/>
  </div>
  </form>
</div>
</div>
<script>
  $(function (){
    $('#save').delay(2500).fadeOut('slow');
  })
</script>
</body>
</html>
