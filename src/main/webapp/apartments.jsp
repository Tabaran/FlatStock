<%@ page import="java.util.*" %>
<%@ page import="com.flatstock.model.IApartment"%>


<html>
<a href='/add_apartments'><button>Add Apartments</button></a><br/>
<body>
<table border="1">
  <%
    List<IApartment> apartments = (List<IApartment>)request.getAttribute("apartments");
    for(IApartment apartment: apartments){
      out.println("<tr>");
      out.println("<td>" + apartment.getId() + "</td>");
      out.println("<td>" + apartment.getAddress() + "</td>");
      out.println("<td>" + apartment.getPrice() + "</td>");
      out.println("<td>" + apartment.getDescription() + "</td>");
      out.println("<td>" + apartment.getFloor() + "</td>");
      out.println("<td>" + apartment.getOwnerId() + "</td>");
      out.println("<td><a href='/remove_apartments?id=" + apartment.getId() + "'><button>Remove</button></a></button></td>");
      out.println("<td><a href='/update_apartments?id=" + apartment.getId() + "'><button>Update</button></a></button></td>");
      out.println("</tr>");
    }
  %>
</table>
</body>
</html>
