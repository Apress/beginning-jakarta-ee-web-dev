<%@tag import="java.util.Date, java.text.SimpleDateFormat"
       import="java.util.Calendar, java.util.GregorianCalendar"%>
<%@attribute name="date" required="false"%>
<%
  final String[] WD = {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
  GregorianCalendar cal = new GregorianCalendar();
  if (date != null && date.length() > 0) {
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    fmt.setLenient(true);
    Date d = fmt.parse(date);
    cal.setTime(d);
    }
  out.print(WD[cal.get(Calendar.DAY_OF_WEEK)]);
  %>
