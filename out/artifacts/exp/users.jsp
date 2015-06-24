<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IUser"%>


<html>
<body>
hello!
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
        out.println("<td><a href='/flatStock-1.0-SNAPSHOT/remove_user?user_id=" + user.getId() + "'><button>Remove</button></a></button></td>");
        out.println("<td><a href='/flatStock-1.0-SNAPSHOT/updateUser.jsp'><button>Updatejjjjjjjjjjjjjj</button></a></button></td>");
        out.println("</tr>");
    }

    
%>
</table>
</body>
</html>