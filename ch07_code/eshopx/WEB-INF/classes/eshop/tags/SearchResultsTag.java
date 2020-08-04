package eshop.tags;

import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TagSupport;
import eshop.model.DataManager;

public class SearchResultsTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String var;
  private String keyword = "0";

  public void setVar(String var) {
    this.var = var;
    }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
    }

  public int doEndTag() {
    ServletContext context = pageContext.getServletContext();
    DataManager dataManager =(DataManager)context.getAttribute("dataManager");
    pageContext.setAttribute(var, dataManager.getSearchResults(keyword));
    return EVAL_PAGE;
    }
  }