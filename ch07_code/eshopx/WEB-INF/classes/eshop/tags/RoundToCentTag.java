package eshop.tags;

import javax.servlet.jsp.tagext.TagSupport;

public class RoundToCentTag extends TagSupport {
  static final long serialVersionUID = 1L;
  private String var;
  private double value;

  public void setVar(String var) {
    this.var = var;
    }

  public void setValue(Double value) {
    this.value = value.doubleValue();
    }

  public int doEndTag() {
    pageContext.setAttribute(var,
        Double.valueOf(Math.round(value*100.)/100.).toString());
    return EVAL_PAGE;
    }
  }
