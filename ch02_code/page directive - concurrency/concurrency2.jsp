<%@page language="java" contentType="text/html"%>
<%!
  int k = 0;
  Object syncK = new Object();
  %>
<html><head><title>Concurrency</title></head><body>
<%
  synchronized(syncK) {
    out.print(k);
    int j = k + 1;
    Thread.sleep(5000);
    k = j;
    out.println(" -> " + k);
    }
  %>
</body></html>