<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IUser"%>


<html>
<a href='/addUser.jsp'><button>Add User</button></a><br/>
<body>
<table border="1">
<%
    List<IUser> users = (List<IUser>)request.getAttribute("users");
    for(IUser user: users){
        out.println("<tr>");
        out.println("<td>" + user.getId() + "</td>");
        out.println("<td>" + user.getFirstName() + "</td>");
        out.println("<td>" + user.getLastName() + "</td>");
        out.println("<td>" + user.getEmail() + "</td>");
        out.println("<td>" + user.getLogin() + "</td>");
        out.println("<td>" + user.getPassword() + "</td>");
        out.println("<td>" + user.getGender() + "</td>");
        out.println("<td><a href='/remove_user?id=" + user.getId() + "'><button>Remove</button></a></button></td>");
        out.println("<td><a href='/update_user?id=" + user.getId() + "'><button>Update</button></a></button></td>");
        out.println("</tr>");
    }
%>
</table>
</body>
</html>