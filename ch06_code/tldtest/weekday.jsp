<%@page language="java" contentType="text/html"%>
<%@taglib uri="/WEB-INF/tlds/wow.tld" prefix="wow"%>
<% String d = request.getParameter("d"); %>
<html><head><title>weekday bodyless tag</title></head><body>
weekday today: <wow:weekday/><br/>
weekday <%=d%>: <wow:weekday date="<%=d%>"/><br/>
</body></html>
