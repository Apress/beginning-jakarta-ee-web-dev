package eshop.renderers;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.Renderer;
import eshop.components.InputEntryComponent;

public class InputEntryRenderer extends Renderer {
	
  private void encodeInput(ResponseWriter respWr, InputEntryComponent cmp)
      throws IOException {
    FacesContext ctxt = FacesContext.getCurrentInstance();
    respWr.startElement("input", cmp);
    respWr.writeAttribute("type", "text", "type");
    respWr.writeAttribute("id", cmp.getClientId(ctxt), "id");
    respWr.writeAttribute("name", cmp.getClientId(ctxt), "name");
    if(cmp.getValue() != null) {
      respWr.writeAttribute("value", cmp.getValue().toString(), "value");
      }
    respWr.endElement("input");
    }
  
  private void encodeLabel(ResponseWriter respWr, InputEntryComponent cmp)
      throws IOException {
    respWr.startElement("label", cmp);
    respWr.write(cmp.getLabel());
    if (cmp.isRequired()) {
      respWr.write("*");
      }
    respWr.endElement("label");
    }
  
  private void encodeMessage(FacesContext ctxt, ResponseWriter respWr,
      InputEntryComponent cmp) throws IOException {
    Iterator<FacesMessage> it = ctxt.getMessages(cmp.getClientId(ctxt));
    // Notice: an if instead of a while
    if (it.hasNext()){
      FacesMessage mess = (FacesMessage)it.next();
      if (!cmp.isValid()) {
        String errorStyleClass =
            (String)cmp.getAttributes().get("errorStyleClass");
        respWr.startElement("span", cmp);
        respWr.writeAttribute("class", errorStyleClass, "class");
        respWr.write(mess.getDetail());
        respWr.endElement("span");
        }
      }
    }

  // Overriden methods
  public void decode(FacesContext ctxt, UIComponent cmp) {
    InputEntryComponent ieCmp = (InputEntryComponent)cmp;
    Map<String, String> requestMap =
    		ctxt.getExternalContext().getRequestParameterMap();
    String clientId = cmp.getClientId(ctxt);
    String val = (String)requestMap.get(clientId);
    ((UIInput)ieCmp).setSubmittedValue(val);
    }
  
  public void encodeBegin(FacesContext ctxt, UIComponent cmp)
      throws IOException {
    InputEntryComponent ieCmp = (InputEntryComponent)cmp;
    ResponseWriter respWr = ctxt.getResponseWriter();
    encodeLabel(respWr, ieCmp);
    encodeInput(respWr, ieCmp);
    encodeMessage(ctxt, respWr, ieCmp);
    respWr.flush();
    }
  
  public Object getConvertedValue(FacesContext ctxt, UIComponent cmp,
      Object subVal) throws ConverterException {
    Object convVal = null;
    ValueExpression valExpr = cmp.getValueExpression("value");
    if (valExpr != null) {
      Class<?> valType = valExpr.getType(ctxt.getELContext());
      if (valType != null) {
        convVal = subVal;
        if (!valType.equals(Object.class) && !valType.equals(String.class)) {
          Converter converter = ((UIInput)cmp).getConverter();
          converter =  ctxt.getApplication().createConverter(valType);
          if (converter != null ) {
            convVal = converter.getAsObject(ctxt, cmp, (String)subVal);
            }
          }
        }
      }
    return convVal;
    }
  }
