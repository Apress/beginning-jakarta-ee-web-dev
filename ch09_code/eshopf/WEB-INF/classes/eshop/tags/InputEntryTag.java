package eshop.tags;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class InputEntryTag extends UIComponentELTag {
  private ValueExpression  errorStyleClass;
  private ValueExpression  label;
  private ValueExpression  required;
  private ValueExpression  requiredMessage;
  private ValueExpression  value;

  // Setters
  public void setErrorStyleClass(ValueExpression errorStyleClass) {
    this.errorStyleClass = errorStyleClass;
    }
  public void setLabel(ValueExpression label) {
    this.label = label;
    }
  public void setRequired(ValueExpression required) {
    this.required = required;
    }
  public void setRequiredMessage(ValueExpression requiredMessage) {
    this.requiredMessage = requiredMessage;
    }
  public void setValue(ValueExpression value) {
    this.value = value;
    }

  // Overridden methods
  public String getComponentType() {
    return "eshop.inputEntry";
    }
  public String getRendererType() {
    return "eshop.inputEntry";
    }
  protected void setProperties(UIComponent cmp) {
    super.setProperties(cmp);
    if (errorStyleClass != null) {
      cmp.setValueExpression("errorStyleClass", errorStyleClass);
      }
    if (label != null) {
      cmp.setValueExpression("label", label);
      }
    if (required != null) {
      cmp.setValueExpression("required", required);
      }
    if (requiredMessage != null) {
      cmp.setValueExpression("requiredMessage", requiredMessage);
      }
    if (value != null) {
      cmp.setValueExpression("value", value);
      }
    }
  public void release() {
    super.release();
    errorStyleClass = null;
    label = null;
    requiredMessage = null;
    value = null;
    required = null;
    }
  }
