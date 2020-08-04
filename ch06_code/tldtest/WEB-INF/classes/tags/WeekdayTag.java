package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WeekdayTag extends TagSupport {
  static final long serialVersionUID = 1L;
  static final String[] WD = {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
  private String date;

  public void setDate(String date) {
    this.date = date;
    }

  public int doEndTag() throws JspException {
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    fmt.setLenient(true);
    if (date != null && date.length() > 0) {
      Date d = new Date();
      try {
        d = fmt.parse(date);
        }
      catch (Exception e) {
        throw new JspException("Date parsing failed: " + e.getMessage());
        }
      cal.setTime(d);
      }
    try {
      pageContext.getOut().print(WD[cal.get(Calendar.DAY_OF_WEEK)]);
      }
    catch (Exception e) {
      throw new JspException("Weekday writing failed: " + e.getMessage());
      }
    return EVAL_PAGE;
    }
  }