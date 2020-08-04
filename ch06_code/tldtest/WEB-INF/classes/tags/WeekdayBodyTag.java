package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WeekdayBodyTag extends BodyTagSupport {
  static final long serialVersionUID = 1L;
  static final String[] WD = {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
  private boolean bodyless = true;

  public int doAfterBody() throws JspException {
    String date = getBodyContent().getString();
    if (date.length() > 0) {
      GregorianCalendar cal = new GregorianCalendar();
      Date d = new Date();
      SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
      fmt.setLenient(true);
      try {
        d = fmt.parse(date);
        }
      catch (Exception e) {
        throw new JspException("Date parsing failed: " + e.getMessage());
        }
      cal.setTime(d);
      try {
          getPreviousOut().print(WD[cal.get(Calendar.DAY_OF_WEEK)]);
          }
        catch (Exception e) {
          throw new JspException("Weekday writing failed: " + e.getMessage());
          }
      bodyless = false;
      }
    return SKIP_BODY;
    }

  public int doEndTag() throws JspException {
    if (bodyless) {
      GregorianCalendar cal = new GregorianCalendar();
      try {
        pageContext.getOut().print(WD[cal.get(Calendar.DAY_OF_WEEK)]);
        }
      catch (Exception e) {
        throw new JspException("Weekday writing failed: " + e.getMessage());
        }
      }
    return EVAL_PAGE;
    }
  }