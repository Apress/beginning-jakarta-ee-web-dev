package eshop.validators;
import javax.faces.validator.Validator;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CCExpiryValidator implements Validator {
  public CCExpiryValidator() {
    }
  public void validate(FacesContext ctxt, UIComponent cmp, Object val) {
    String messS = null;
    String[] fields = ((String)val).split("/", 3);
    if (fields.length != 2) {
      messS = "Expected MM/YY!";
      }
    else {
      int month = 0;
      int year = 0;
      try {
        month = Integer.parseInt(fields[0]);
        year = Integer.parseInt(fields[1]);
        }
      catch (NumberFormatException e) {
        }
      if (month <= 0  ||  month > 12) {
        messS = "Month " + fields[0] + " not valid!";
        }
      else if (year < 0  ||  year > 99) {
        messS = "Year " + fields[1] + " not valid!";
        }
      else {
        GregorianCalendar cal = new GregorianCalendar();
        int thisMonth = cal.get(Calendar.MONTH) + 1;
        int thisYear = cal.get(Calendar.YEAR) - 2000;
        if (year < thisYear  ||  year == thisYear && month < thisMonth) {
          messS = "Credit card expired!";
          }
        }
      }
    if (messS != null) {
      FacesMessage mess = new FacesMessage(
          FacesMessage.SEVERITY_ERROR, messS, messS);
      throw new ValidatorException(mess);
      }
    }
  }