<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html><head><title>Request Parameters with JSTL</title></head><body>
  Map size = <c:out  value="${fn:length(paramValues)}"/>
  <table border="1">
    <tr><td>Map element</td><td>Par name</td><td>Par value[s]</td></tr>
    <c:set  var="k" value="0"/>
    <c:forEach var="par" items="${paramValues}"><tr>
      <td><c:out value="${k}"/></td>
      <td><c:out value="'${par.key}'"/></td>
      <td><c:forEach var="val" items="${par.value}">
        <c:out value="'${val}'"/>
        </c:forEach></td>
      <c:set var="k" value="${k+1}"/>
      </tr></c:forEach>
    </table>
</body></html>
