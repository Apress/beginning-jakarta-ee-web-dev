package myPkg;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

public class MyBean {
  @SuppressWarnings("unchecked")
  private ArrayList<String>[] choices = new ArrayList[3];
  private String choice1, choice2, choice3;
  private Object oneValue;
  private SelectItem[] selects;

  public MyBean()  {
    selects = new SelectItem[3];
    selects[0] = new SelectItem("1", "one");
    selects[1] = new SelectItem("2", "two");
    selects[2] = new SelectItem("3", "three");
    for (int kC = 0; kC < choices.length; kC++) {
      choices[kC] = new ArrayList<String>();
      }
    }

  // ---------- Getters
  public Object[] getChoices1() { return choices[0].toArray(); }
  public Object[] getChoices2() { return choices[1].toArray(); }
  public Object[] getChoices3() { return choices[2].toArray(); }
  public String getChoice1() { return choice1; }
  public String getChoice2() { return choice2; }
  public String getChoice3() { return choice3; }
  public Object getOneValue() { return oneValue; }
  public SelectItem[] getSelects() { return selects; }  

  // ---------- Setters
  public void setChoices(Object[] cc, int kC) {
	    int len=0;
	    if (cc != null) len = cc.length;
	    if (len != 0) {
	      choices[kC].clear();
	      choices[kC] = new ArrayList<String>(len);
	      for (int k = 0; k < len; k++) {
	        choices[kC].add((String)cc[k]);
	        }
	      }
	    }
  public void setChoices1(Object[] cc) { setChoices(cc, 0); }
  public void setChoices2(Object[] cc) { setChoices(cc, 1); }
  public void setChoices3(Object[] cc) { setChoices(cc, 2); }
  public void setChoice1(String c) { choice1 = c; }
  public void setChoice2(String c) { choice2 = c; }
  public void setChoice3(String c) { choice3 = c; }
  public void setOneValue(Object v) { oneValue = v; }
  }
