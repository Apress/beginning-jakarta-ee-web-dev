package eshop.beans;

public class CartItem {
  private String author;
  private String title;
  private double price;
  private String bookID;
  private int quantity;
  private double subtotal;

 public CartItem(Book book, int quantity) {
    bookID = book.getId();
    title = book.getTitle();
    author = book.getAuthor();
    price = book.getPrice();
    this.quantity = quantity;
    subtotal = Math.round(price*quantity*100.)/100.;
    }

  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public double getPrice() { return price; }
  public void setPrice(double price) {
    this.price = price;
    subtotal = Math.round(price*quantity*100.)/100.;
    }

  public String getBookID() { return bookID; }
  public void setBookId(String bookID) { this.bookID = bookID; }

  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
    subtotal = Math.round(price*quantity*100.)/100.;
    }

  public double getSubtotal() { return subtotal; }
  }
