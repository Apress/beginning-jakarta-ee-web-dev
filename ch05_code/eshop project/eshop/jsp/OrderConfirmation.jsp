<%@page language="java" contentType="text/html"%>
<%@page import="java.util.Hashtable"%>
<%@page import="eshop.beans.CartItem"%>
<jsp:useBean id="dataManager" scope="application"
  class="eshop.model.DataManager"/>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Order</title>
  <link rel="stylesheet" href="/eshop/css/eshop.css" type="text/css"/>
  </head>
<body>
<jsp:include page="TopMenu.jsp" flush="true"/>
<jsp:include page="LeftMenu.jsp" flush="true"/>
<div class="content">
  <h2>Order</h2>
  <jsp:useBean id="customer" class="eshop.beans.Customer"/>
  <jsp:setProperty property="*" name="customer"/>
<%
    @SuppressWarnings("unchecked")
    Hashtable<String, CartItem> cart =
        (Hashtable<String, CartItem>)session.getAttribute("shoppingCart");
    long orderId = dataManager.insertOrder(customer, cart);
    if (orderId > 0L) {
      session.invalidate();
  %>
      <p class="info">
        Thank you for your purchase.<br/>
        Your Order Number is: <%=orderId%>
        </p>
<%
      }
    else {
      %><p class="error">Unexpected error processing the order!</p><%
      }
  %>
  </div>
</body>
</html>
