package myPkg;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
public class ParsingExceptionHandler extends DefaultHandler {
  public SAXParseException parsingException = null;
  public String errorLevel = null;
  public void warning(SAXParseException e) {
    errorLevel = "Warning";
    parsingException = e;
    }
  public void error(SAXParseException e) {
    errorLevel = "Error";
    parsingException = e;
    }
  public void fatalError(SAXParseException e) {
    errorLevel = "Fatal error";
    parsingException = e;
    }
  }
