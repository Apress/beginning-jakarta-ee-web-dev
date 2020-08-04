package eshop.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import eshop.beans.Book;

public class BookPeer {
  public static ArrayList<Book> searchBooks(DataManager dataManager,
      String keyword) {
    ArrayList<Book> books = new ArrayList<Book>();
    Connection connection = dataManager.getConnection();
    if (connection != null) {
      try {
        Statement s = connection.createStatement();
        String sql = "select book_id, title, author, price from books"
            + " where title like '%" + keyword.trim() + "%'"
            + " or author like '%" + keyword.trim() + "%'";
        try {
          ResultSet rs = s.executeQuery(sql);
          try {
            while (rs.next()) {
              Book book = new Book();
              book.setId(rs.getString(1));
              book.setTitle(rs.getString(2));
              book.setAuthor(rs.getString(3));
              book.setPrice(rs.getDouble(4));
              books.add(book);
              }
            }
          finally { rs.close(); }
          }
        finally { s.close(); }
        }
      catch (SQLException e) {
        System.out.println("Could not search for books:" + e.getMessage());
        }
      finally {
        dataManager.putConnection(connection);
        }
      }
    return books;
    }
  
  public static ArrayList<Book> getBooksByCategory(DataManager dataManager,
      String categoryId) {
    ArrayList<Book> books = new ArrayList<Book>();
    Connection connection = dataManager.getConnection();
    if (connection != null) {
      try {
        Statement s = connection.createStatement();
        String sql = "select book_id, title, author, price from books"
            + " where category_id=" + categoryId;
        try {
          ResultSet rs = s.executeQuery(sql);
          try {
            while (rs.next()) {
              Book book = new Book();
              book.setId(rs.getString(1));
              book.setTitle(rs.getString(2));
              book.setAuthor(rs.getString(3));
              book.setPrice(rs.getDouble(4));
              books.add(book);
              }
            }
          finally { rs.close(); }
          }
        finally { s.close(); }
        }
      catch (SQLException e) {
        System.out.println("Could not get books: " + e.getMessage());
        }
      finally {
        dataManager.putConnection(connection);
        }
      }
    return books;
    }

  public static Book getBookById(DataManager dataManager, String bookID) {
    Book book = null;
    Connection connection = dataManager.getConnection();
    if (connection != null) {
      try {
        Statement s = connection.createStatement();
        String sql = "select book_id, title, author, price from books"
            + " where book_id=" + bookID;
        try {
          ResultSet rs = s.executeQuery(sql);
          if (rs.next()) {
            book = new Book();
            book.setId(rs.getString(1));
            book.setTitle(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setPrice(rs.getDouble(4));
            }
          }
        finally { s.close(); }
        }
      catch (SQLException e) {
        System.out.println("Could not get book: " + e.getMessage());
        }
      finally {
        dataManager.putConnection(connection);
        }
      }
    return book;
    }
  }

