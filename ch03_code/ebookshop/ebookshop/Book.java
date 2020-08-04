package ebookshop;
public class Book {
  String title;
  float  price;
  int    quantity;
  public Book(String t, float p, int q) {
    title    = t;
    price    = p;
    quantity = q;
    }
  public String getTitle()         { return title; }
  public void   setTitle(String t) { title = t; }
  public float  getPrice()         { return price; }
  public void   setPrice(float p)  { price = p; }
  public int    getQuantity()      { return quantity; }
  public void   setQuantity(int q) { quantity = q; }
  }
