package myPkg.i18n;
import java.util.*;
public class MyBundle_en extends ListResourceBundle {
  public Object[][] getContents() {return contents;}
  static final Object[][] contents = {
    {"login.loginmess","Please login with ID and password"},
    {"login.submit","Submit"},
    {"login.choose","Choose the language"},
    {"login.english","English"},
    {"login.italian","Italian"},
    {"login.hello","Hello {0}!"}
    };
  }