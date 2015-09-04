<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static com.flatstock.controller.PhotoController.*"%>
<%@ taglib prefix="ut" uri="/WEB-INF/user_tags.tld"%>
<html>
<head>
    <title></title>
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel='stylesheet' href='main.css'>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
  <img src="<%= GET_PHOTO_PATH%>?<%= PHOTO%>=${sessionScope.user.getPhotoUrl()}&id=${sessionScope.user.getId()}"/>
  <ut:user_apartments userId="${sessionScope.user.getId()}"/>
</body>
</html>
