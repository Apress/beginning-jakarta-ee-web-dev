package myPkg;
import javax.xml.transform.TransformerException;
public class TransformerExceptionHandler
    implements javax.xml.transform.ErrorListener {
  public TransformerException transformationException = null;
  public String errorLevel = null;
  public void warning(TransformerException e) {
    errorLevel = "Warning";
    transformationException = e;
    }
  public void error(TransformerException e) {
    errorLevel = "Error";
    transformationException = e;
    }
  public void fatalError(TransformerException e) {
    errorLevel = "Fatal error";
    transformationException = e;
    }
  }
