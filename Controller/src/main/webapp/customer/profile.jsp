<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 29.11.15
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
  Hello Customer!
  <c:url value="/logout" var="logoutUrl" />
  <form action="${logoutUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input  class="btn" type="submit" value="Sign Out"/>
  </form>
</body>
</html>
