<%@ page import="com.flatstock.model.IUser"%><html>
<%@ page import="com.flatstock.model.Gender"%><html>

<%IUser user = (IUser)request.getAttribute("user");%>

<body>
<form method="POST" action="/update_user">
    <input type="hidden" name="id" value="<%= user.getId()%>" />
    <p>First Name: <input type="text" name="first_name" value="<%= user.getFirstName()%>"/></p>
    <p>Last Name: <input type="text" name="last_name" value="<%= user.getLastName()%>"/></p>
    <p>Email: <input type="text" name="email" value="<%= user.getEmail()%>"/></p>
    <p>Login: <input type="text" name="login" value="<%= user.getLogin()%>"/></p>
    <p>Password: <input type="password" name="password" value="<%= user.getPassword()%>"/></p>
    <p>Gender:
        male <input type="radio" name="gender" value="male" <%if(user.getGender().equals(Gender.MALE)) out.print("checked"); %>/>
        female <input type="radio" name="gender" value="female" <%if(user.getGender().equals(Gender.FEMALE)) out.print("checked"); %>/>
    </p>
    <p><input type="submit" value="Submit"/></p>
</form>
</body>
</html>