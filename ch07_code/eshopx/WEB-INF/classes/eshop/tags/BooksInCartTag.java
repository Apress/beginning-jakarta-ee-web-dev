package eshop.tags;

import java.util.Hashtable;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpSession;

import eshop.beans.CartItem;

public class BooksInCartTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String var;

  public void setVar(String var) {
    this.var = var;
    }

  public int doEndTag() {
    HttpSession session = pageContext.getSession();
    @SuppressWarnings("unchecked")
    Hashtable<String, CartItem> shoppingCart =
        (Hashtable<String, CartItem>)session.getAttribute("shoppingCart");
    if (shoppingCart != null) {
      pageContext.setAttribute(var, shoppingCart.elements());
      }
    return EVAL_PAGE;
    }
  }
