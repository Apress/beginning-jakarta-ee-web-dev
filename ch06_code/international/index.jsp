<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="langExt" value="en"/>
<c:if test="${param.lang!=null}">
  <c:set var="langExt" value="${param.lang}"/>
  </c:if>
<fmt:setLocale value="${langExt}"/>
<fmt:setBundle basename="myPkg.i18n.MyBundle"
  var="lang" scope="session"/>
<html><head><title>i18n</title></head><body>
<h1><fmt:message key="login.loginmess" bundle="${lang}"/></h1>
<form method="post" action="">
  <input name=id>
  <input type="password" name=passwd>
  <input type="submit"
    value="<fmt:message key="login.submit" bundle="${lang}"/>"
    >
<h2><fmt:message key="login.choose" bundle="${lang}"/></h2>
</form>
<a href="index.jsp?lang=en">
  <fmt:message key="login.english" bundle="${lang}"/>
  </a>
&nbsp;
<a href="index.jsp?lang=it">
  <fmt:message key="login.italian" bundle="${lang}"/>
  </a>
</body></html>