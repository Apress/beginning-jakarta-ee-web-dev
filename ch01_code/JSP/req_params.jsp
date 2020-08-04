<%@page language="java" contentType="text/html"%>
<%@page import="java.util.*, java.io.*"%>
<%
  Map      map = request.getParameterMap();
  Object[] keys = map.keySet().toArray();
  %>
<html><head><title>Request Parameters</title></head><body>
  Map size = <%=map.size()%>
  <table border="1">
    <tr><td>Map element</td><td>Par name</td><td>Par value[s]</td></tr>
<%
    for (int k = 0; k < keys.length; k++) {
      String[] pars = request.getParameterValues((String)keys[k]);
      out.print("<tr><td>" + k + "</td><td>'" + keys[k] + "'</td><td>");
      for (int j = 0; j < pars.length; j++) {
        if (j > 0) out.print(" ");
        out.print("'" + pars[j] + "'");
        }
      out.println("</td></tr>");
      }
  %>
    </table>
</body></html>
