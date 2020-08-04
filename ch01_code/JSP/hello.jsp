<%@page language="java" contentType="text/html"%>
<html>
<head><title>Hello World dynamic HTML</title></head>
<body>
Hello World!
<%
String userAgent = request.getHeader("user-agent");
out.println("<br/>User-agent: " + userAgent);
%>
</body>
</html>
