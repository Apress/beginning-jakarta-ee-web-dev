package eshop.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;

import eshop.beans.Book;
import eshop.beans.Category;
import eshop.beans.Customer;
import eshop.beans.CartItem;

public class DataManager {

  public Connection getConnection() {
    Connection conn = null;
    try {
      Context ctx = new InitialContext();
      if (ctx != null){
        Context envContext  = (Context)ctx.lookup("java:/comp/env");
        if (envContext != null) {
          DataSource ds = (DataSource)envContext.lookup("jdbc/mysql");
          if (ds != null) {
            conn = ds.getConnection();
            }
          }
        }
      }
    catch (Exception e) {
      System.out.println("Could not connect to DB: " + e.getMessage());
      e.printStackTrace(System.out);
      }
    return conn;
    }

  public void putConnection(Connection conn) {
    if (conn != null) {
      try { conn.close(); }
      catch (SQLException e) { }
      }
    }

  //---------- Category operations ----------
  public String getCategoryName(String categoryID) {
    Category category = CategoryPeer.getCategoryById(this, categoryID);
    return (category == null) ? null : category.getName();
    }

  public List<Category> getCategories() {
    return CategoryPeer.getAllCategories(this);
    }

  //---------- Book operations ----------
  public ArrayList<Book> getBooksInCategory(String categoryID) {
    return BookPeer.getBooksByCategory(this, categoryID);
    }

  public Book getBookDetails(String bookID) {
    return BookPeer.getBookById(this, bookID);
    }

  public ArrayList<Book> getSearchResults(String keyword) {
    return BookPeer.searchBooks(this, keyword);
    }

  //---------- Order operations ----------
  public long insertOrder(Customer customer,
		   Hashtable<String, CartItem> shoppingCart
		   ) {
    long returnValue = 0L;
    long orderId = System.currentTimeMillis();
    Connection connection = getConnection();
    if (connection != null) {
      Statement stmt = null;
      try {
        connection.setAutoCommit(false);
        stmt = connection.createStatement();
        try {
          OrderPeer.insertOrder(stmt, orderId, customer);
          OrderDetailsPeer.insertOrderDetails(stmt, orderId, shoppingCart);
          try { stmt.close(); }
          finally { stmt = null; }
          connection.commit();
          returnValue = orderId;
          }
        catch (SQLException e) {
          System.out.println("Could not insert order: " + e.getMessage());
          try { connection.rollback(); }
          catch (SQLException ee) { }
          }
        }
      catch (SQLException e) {
        System.out.println("Could not insert order: " + e.getMessage());
        }
      finally {
        if (stmt != null) {
          try { stmt.close(); }
          catch (SQLException e) { }
          }
        putConnection(connection);
        }
      }
    return returnValue;
    }
  }
