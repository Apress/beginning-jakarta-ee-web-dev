<%@page language="java" contentType="text/html"%>
<%@page import="java.util.*, java.io.*"%>
<%
  int    len = request.getContentLength();
  byte[] buf = null;
  int    n = 0;
  if (len > 0) {
    buf = new byte[len];
    n = request.getInputStream().read(buf);
    }
  %>
<html><head><title>Test request.getInputStream</title></head><body>
  <form action="" method="post" enctype="multipart/form-data">
    <input type="hidden" name="oneTwoThree" value="123"/>
    <input type="file" name="fil"/>
    <input type="submit"/>
    </form>
  <table border="1">
    <tr><td>getContentType()</td><td><%=request.getContentType()%></td></tr>
    <tr><td>getContentLength()</td><td><%=len%></td></tr>
<%
    out.print("<tr><td>getInputStream(): " + n + "</td><td><pre>");
    for (int k = 0; k < n; k++) out.print((char)buf[k]);
    out.println("</pre></td></tr>");
  %>
    </table>
</body></html>
