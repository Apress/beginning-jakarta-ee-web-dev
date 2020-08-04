package eshop.tags;

import java.util.Hashtable;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpSession;

import eshop.beans.CartItem;

public class UpdateBookTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String bookID;
  private String quantity;

  public void setBookID(String bookID) {
    this.bookID = bookID;
    }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
    }

  public int doEndTag() {
    HttpSession session = pageContext.getSession();
    @SuppressWarnings("unchecked")
    Hashtable<String, CartItem> shoppingCart =
        (Hashtable<String, CartItem>)session.getAttribute("shoppingCart");
    CartItem item = (CartItem)shoppingCart.get(bookID);
    if (item != null) {
      item.setQuantity(quantity);
      }
    return EVAL_PAGE;
    }
  }
