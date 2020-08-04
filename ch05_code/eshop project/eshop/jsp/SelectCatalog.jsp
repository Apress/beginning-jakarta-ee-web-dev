<%@page language="java" contentType="text/html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="eshop.beans.Book"%>
<jsp:useBean id="dataManager" scope="application"
  class="eshop.model.DataManager"/>
<% String base = (String)application.getAttribute("base"); %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Browse Catalog</title>
  <link rel="stylesheet" href="/eshop/css/eshop.css" type="text/css"/>
  </head>
<body>
<jsp:include page="TopMenu.jsp" flush="true"/>
<jsp:include page="LeftMenu.jsp" flush="true"/>
<%     
  String categoryId = request.getParameter("id");
  String categoryName = null;
  if (categoryId != null && !categoryId.trim().equals("")) {
    try {
      categoryName = dataManager.getCategoryName(categoryId);
      }
    catch(NumberFormatException e) {}
    }
  if (categoryName != null) {
  %>
    <div class="content">
      <h2>Select Catalog</h2>
      <p>Category: <strong><%=categoryName%></strong></p>
      <table>
        <tr>
          <th>Title</th>
          <th>Author</th>
          <th>Price</th>
          <th>Details</th>
          </tr>
<%
        ArrayList<Book> books = dataManager.getBooksInCategory(categoryId);
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
          Book book = (Book)iterator.next();
          String pId = book.getId();
  %>
          <tr>
            <td><%=book.getTitle()%></td>
            <td><%=book.getAuthor()%></td>
            <td><%=book.getPrice()%></td>
            <td><a class="link1"
              href="<%=base%>?action=bookDetails&bookId=<%=pId%>">
              Details</a></td>
            </tr>
<%
          }
  %>
        </table>
      </div>
<%
    }
  else {
	%><p class="error">Invalid category!</p><%
	}
%>
</body>
</html>
