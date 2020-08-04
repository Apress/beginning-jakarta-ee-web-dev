<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html><head><title>Includes</title></head><body>
<table border="1">
  <tr><th>incl B</th><th>incl C</th><th>C contains</th></tr>
  <tr><td>jsp:include</td><td>jsp:include</td><td><jsp:include page="d/b_act.jsp"/></td></tr>
  <tr><td>jsp:include</td><td>@include</td><td><jsp:include page="d/b_dir.jsp"/></td></tr>
  <tr><td>@include</td><td>jsp:include</td><td><%@include file="d/b_act.jsp"%></td></tr>
  <tr><td>@include</td><td>@include</td><td><%@include file="d/b_dir.jsp"%></td></tr>
  </table>
</body></html>