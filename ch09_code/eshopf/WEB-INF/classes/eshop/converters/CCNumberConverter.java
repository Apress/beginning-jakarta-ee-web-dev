package eshop.converters;
import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.convert.ConverterException;

public class CCNumberConverter implements Converter {
  //
  // getAsObject extracts from the input string all numeric characters
  public Object getAsObject(FacesContext ctx, UIComponent cmp,
      String val) {
    String convVal = null;
    if ( val != null ) {
      char[] chars = val.trim().toCharArray();
      convVal = "";
      for (int k = 0; k < chars.length; k++) {
        if (chars[k] >= '0' && chars[k] <= '9') {
          convVal += chars[k];
          }
        }
/*
      System.out.println("CCNumberConverter.getAsObject: '"
          + val + "' -> '" + convVal + "'");
*/
      }
    return convVal;
    }
  //
  // getAsString inserts into the object string spaces to make it readable
  // default: nnnn nnnn nnnn nnnn, Amex: nnnn nnnnnn nnnnn
  public String getAsString(FacesContext ctx, UIComponent cmp, Object val)
      throws ConverterException {
    String convVal = null;
    if (val != null) {
      int[] spaces = {3, 7, 11, 99};
      int[] amex = {3, 9, 99};
      String sVal = null;
      try {
        sVal = (String)val; // The val object should be a String!
        }
      catch (ClassCastException e) {
        throw new ConverterException("CCNumberConverter: Conversion Error");
        }
      int kSpace = 0;
      char[] chars = sVal.toCharArray();
      if (chars.length == 15) spaces = amex;
      convVal = "";
      for (int k = 0; k < chars.length; k++) {
        convVal += chars[k];
        if (spaces[kSpace] == k) {
          convVal += ' ';
          kSpace++;
          }
        }
/*
      System.out.println("CCNumberConverter.getAsString: '"
          + sVal + "' -> '" + convVal + "'");
*/
      }
    return convVal;
    }
  }
