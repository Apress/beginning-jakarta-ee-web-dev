import java.io.Serializable;
import java.util.GregorianCalendar;
public class ServerTime implements Serializable {
	private static final long serialVersionUID = 1L;
	String when;  
	public ServerTime() { when = new GregorianCalendar().getTime().toString(); }
	public String getWhen() { return new GregorianCalendar().getTime().toString(); }
	public void setWhen(String w) { when = w; }
}