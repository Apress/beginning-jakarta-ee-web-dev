<%@page language="java" contentType="text/html"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@page session="true" import="java.util.Vector, ebookshop.Book"%>
<html>
<head>
  <title>E-bookshop</title>
  <style type="text/css">
    body {background-color: gray; font-size: 10pt;}
    h1 {font-size: 20pt;}
    table {background-color: white;}
    </style>
  </head>
<body>
  <H1>Your online Bookshop</H1>
  <hr/><p/>
<%  // Scriptlet 1: check whether the book list is ready
  Vector booklist =
      (Vector<ebookshop.Book>)session.getAttribute("ebookshop.list");
  if (booklist == null) {
    response.sendRedirect("/ebookshop/eshop");
    }
  else {
  %>
    <form name="addForm" action="eshop" method="POST">
      <input type="hidden" name="do_this" value="add">
      Book:
      <select name=book>
<%  // Scriptlet 2: copy the book list to the selection control
        for (int i = 0; i < booklist.size(); i++) {
          out.println("<option>" + (String)booklist.elementAt(i) + "</option>");
          }
  %>
        </select>
      Quantity: <input type="text" name="qty" size="3" value="1">
      <input type="submit" value="Add to Cart">
      </form>
    <p/>
<%  // Scriptlet 3: check whether the shopping cart is empty
    Vector<ebookshop.Book> shoplist =
        (Vector<ebookshop.Book>)session.getAttribute("ebookshop.cart");
    if (shoplist != null  &&  shoplist.size() > 0) {
  %>
      <table border="1" cellpadding="2">
      <tr>
      <td>TITLE</td>
      <td>PRICE</td>
      <td>QUANTITY</td>
      <td></td>
      </tr>
<%  // Scriptlet 4: display the books in the shopping cart
      for (int i = 0; i < shoplist.size(); i++) {
        Book aBook = shoplist.elementAt(i);
  %>
        <tr>
          <form name="removeForm" action="eshop" method="POST">
            <input type="hidden" name="position" value="<%=i%>">
            <input type="hidden" name="do_this" value="remove">
            <td><%=aBook.getTitle()%></td>
            <td align="right">$<%=aBook.getPrice()%></td>
            <td align="right"><%=aBook.getQuantity()%></td>
            <td><input type="submit" value="Remove from Cart"></td>
            </form>
          </tr>
<%
        } // for (int i..
  %>
      </table>
      <p/>
      <form name="checkoutForm" action="eshop" method="POST">
        <input type="hidden" name="do_this" value="checkout">
        <input type="submit" value="Checkout">
        </form>
<%
      } // if (shoplist..
    } // if (booklist..else..
  %>
  </body>
</html>
