<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head><title>Action elements: element, attribute</title></head>
<body>
<jsp:element name="myElem">
  <jsp:attribute name="myElemAttr">myElemAttr's value</jsp:attribute>
  <jsp:body>myElem's body</jsp:body>
  </jsp:element>
<br/>
<jsp:include page="text.txt"/>
<br/>
<jsp:include>
  <jsp:attribute name="page">text.txt</jsp:attribute>
  </jsp:include>
</body>
</html>