<%@page language="java" contentType="text/html"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="wow"%>
<% String d = request.getParameter("d"); %>
<html><head><title>weekday bodyless tag</title></head><body>
weekday today: <wow:weekday/><%=pageContext.getAttribute("dayw")%><br/>
weekday <%=d%>: <wow:weekday date="<%=d%>"/><%=pageContext.getAttribute("dayw")%>
</body></html>
