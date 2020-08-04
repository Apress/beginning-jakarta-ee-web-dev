package eshop.tags;

import java.util.Hashtable;
import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpSession;
import eshop.model.DataManager;
import eshop.beans.Book;
import eshop.beans.CartItem;

public class AddBookTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String bookID;

  public void setBookID(String bookID) {
    this.bookID = bookID;
    }

  public int doEndTag() {
    HttpSession session = pageContext.getSession();
    @SuppressWarnings("unchecked")
    Hashtable<String, CartItem> shoppingCart =
    		(Hashtable<String, CartItem>)session.getAttribute("shoppingCart");
    if (shoppingCart == null) {
      shoppingCart = new Hashtable<String, CartItem>(10);
      }
    ServletContext context = pageContext.getServletContext();
    DataManager dataManager =(DataManager)context.getAttribute("dataManager");
    try {
      Book book = dataManager.getBookDetails(bookID);
      if (book != null) {
        CartItem item = new CartItem(book, 1);
        shoppingCart.remove(bookID);
        shoppingCart.put(bookID, item);
        session.setAttribute("shoppingCart", shoppingCart);
        }
      }
    catch (Exception e) {}
    return EVAL_PAGE;
    }
  }
