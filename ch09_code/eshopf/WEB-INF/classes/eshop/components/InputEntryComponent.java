package eshop.components;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class InputEntryComponent extends UIInput {
  private String label;
  public InputEntryComponent(){
    this.setRendererType("eshop.inputEntry");
    }
  public String getLabel() {
    return label;
    }
  public void setLabel(String label) {
    this.label = label;
    }

  // Overridden methods
  public String getFamily() {
    return "eshop.inputEntry";
    }
  public void restoreState(FacesContext ctxt, Object state) {
    Object val[] = (Object[])state;
    super.restoreState(ctxt, val[0]);
    label = (String)val[1];
    }
  public Object saveState(FacesContext ctxt) {
    Object val[] = new Object[2];
    val[0] = super.saveState(ctxt);
    val[1] = label;
    return ((Object)val);
    }
  }