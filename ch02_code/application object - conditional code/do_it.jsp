<%@page language="java" contentType="text/html"%>
<html><head><title>Conditional code ON</title></head>
<body>Conditional code
<%
  application.setAttribute("do_it", "");
  if (application.getAttribute("do_it") == null) out.print("not");
  %>
enabled</body></html>
