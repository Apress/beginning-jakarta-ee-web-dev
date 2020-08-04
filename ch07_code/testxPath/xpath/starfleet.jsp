<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:import url="starfleet.xml" var="sf"/>
<x:parse doc="${sf}" varDom="dom"/>
<html><head>
  <title>Parsing starfleet.xml</title>
  <style>th {text-align:left}</style>
  </head>
<body>
<table border="1">
  <tr><th>Name</th><th>S/N</th><th>Class</th><th>Year</th><th>Captain</th></tr>
  <x:forEach var="tag" select="$dom//starship">
    <tr>
      <td><x:out select="$tag/@name"/></td>
      <td><x:out select="$tag/@sn"/></td>
      <td><x:out select="$tag/class"/></td>
      <td><x:out select="$tag/class/@commissioned"/></td>
      <td><x:out select="$tag/captain"/></td>
      </tr>
    </x:forEach>
  </table>
</body>
</html>