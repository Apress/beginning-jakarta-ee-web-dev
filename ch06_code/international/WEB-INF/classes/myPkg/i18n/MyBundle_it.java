package myPkg.i18n;
import java.util.*;
public class MyBundle_it extends ListResourceBundle {
  public Object[][] getContents() {return contents;}
  static final Object[][] contents = {
    {"login.loginmess","Loggati con ID e password"},
    {"login.submit","Invia"},
    {"login.choose","Scegli la lingua"},
    {"login.english","Inglese"},
    {"login.italian","Italiano"},
    {"login.hello","Ciao {0}!"}
    };
  }