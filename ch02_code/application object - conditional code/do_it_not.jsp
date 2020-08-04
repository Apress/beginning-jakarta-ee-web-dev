<%@page language="java" contentType="text/html"%>
<html><head><title>Conditional code OFF</title></head>
<body>Conditional code
<%
  application.removeAttribute("do_it");
  if (application.getAttribute("do_it") == null) out.print("not");
  %>
enabled</body></html>
