package eshop.tags;

import java.util.Hashtable;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.ServletContext;

import eshop.beans.CartItem;
import eshop.beans.Customer;
import eshop.model.DataManager;

public class InsertOrderTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String var;
  private Customer customer;

  public void setVar(String var) {
    this.var = var;
    }

  public void setCustomer(Customer customer) {
    this.customer = customer;
    }

  public int doEndTag() {
    ServletContext context = pageContext.getServletContext();
    DataManager dataManager =(DataManager)context.getAttribute("dataManager");
    HttpSession session = pageContext.getSession();
    @SuppressWarnings("unchecked")
    Hashtable<String, CartItem> cart =
        (Hashtable<String, CartItem>)session.getAttribute("shoppingCart");
    long orderID = dataManager.insertOrder(customer, cart);
    if (orderID > 0L) session.invalidate();
    pageContext.setAttribute(var, Long.valueOf(orderID).toString());
    return EVAL_PAGE;
    }
  }
