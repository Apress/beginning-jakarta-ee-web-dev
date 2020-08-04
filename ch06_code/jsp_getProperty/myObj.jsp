<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="tests.myclasses.MyClass"%>
<%@page trimDirectiveWhitespaces="true"%>
<html>
<head>
<title>myObj</title>
</head>
<body>
	<jsp:useBean id="obj" class="tests.myclasses.MyClass" scope="session">
		<jsp:setProperty name="obj" property="i" value="11" />
	</jsp:useBean>
	<jsp:getProperty name="obj" property="i" />
	<jsp:setProperty name="obj" property="i" value="22" />
	<jsp:getProperty name="obj" property="i" />
</body>
</html>