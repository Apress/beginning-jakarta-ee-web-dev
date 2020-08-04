<%@page language="java" contentType="text/html"%>
<%@page import="java.util.Enumeration"%>
<html><head><title>Request Headers</title></head><body>
<%
  Enumeration headers = request.getHeaderNames();
  int kh = 0;
  while (headers.hasMoreElements()) {
    String hName = (String)headers.nextElement();
    out.println("------- " + hName);
    Enumeration hValues = request.getHeaders(hName);
    while (hValues.hasMoreElements()) {
      out.println("<br/>&nbsp;&nbsp;&nbsp;" + hValues.nextElement());
      }
    out.println("<br/>");
    }
  %>
</body></html>
