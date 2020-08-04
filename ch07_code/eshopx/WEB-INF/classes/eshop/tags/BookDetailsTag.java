package eshop.tags;

import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TagSupport;
import eshop.model.DataManager;

public class BookDetailsTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String var;
  private String bookID = "0";

  public void setVar(String var) {
    this.var = var;
    }

  public void setBookID(String bookID) {
    this.bookID = bookID;
    }

  public int doEndTag() {
    ServletContext context = pageContext.getServletContext();
    DataManager dataManager =(DataManager)context.getAttribute("dataManager");
    pageContext.setAttribute(var, dataManager.getBookDetails(bookID));
    return EVAL_PAGE;
    }
  }