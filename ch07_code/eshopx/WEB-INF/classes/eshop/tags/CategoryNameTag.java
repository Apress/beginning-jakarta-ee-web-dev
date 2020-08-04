package eshop.tags;

import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TagSupport;
import eshop.model.DataManager;

public class CategoryNameTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String var;
  private String catID = "0";

  public void setVar(String var) {
    this.var = var;
    }

  public void setCatID(String catID) {
    this.catID = catID;
    }

  public int doEndTag() {
    ServletContext context = pageContext.getServletContext();
    DataManager dataManager =(DataManager)context.getAttribute("dataManager");
    pageContext.setAttribute(var, dataManager.getCategoryName(catID));
    return EVAL_PAGE;
    }
  }