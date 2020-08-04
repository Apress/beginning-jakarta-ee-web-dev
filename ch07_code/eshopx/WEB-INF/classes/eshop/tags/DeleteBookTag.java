package eshop.tags;

import java.util.Hashtable;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpSession;

import eshop.beans.CartItem;

public class DeleteBookTag extends TagSupport {
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
    shoppingCart.remove(bookID);
    return EVAL_PAGE;
    }
  }
