package eshop.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import eshop.beans.Category;

public class CategoryPeer {
  public static Category getCategoryById(DataManager dataManager,
      String categoryId) {
    Category category = null;
    Connection connection = dataManager.getConnection();
    if (connection != null) {
      try {
        Statement s = connection.createStatement();
        String sql = "select category_id, category_name from"
          + " categories where category_id=" + categoryId;
        try {
          ResultSet rs = s.executeQuery(sql);
          try {
            if (rs.next()) {
              category = new Category(rs.getInt(1), rs.getString(2));
              }
            }
          finally { rs.close(); }
          }
        finally { s.close(); }
        }
      catch (SQLException e) {
        System.out.println("Could not get categories: " + e.getMessage());
        }
      finally {
        dataManager.putConnection(connection);
        }
      }
    return category;
    }

  public static Hashtable<String, String> getAllCategories(DataManager dataManager) {
    Hashtable<String, String> categories = new Hashtable<String, String>();
    Connection connection = dataManager.getConnection();
    if (connection != null) {    
      try {
        Statement s = connection.createStatement();
        String sql = "select category_id, category_name from categories";
        try {
          ResultSet rs = s.executeQuery(sql);
          try {
            while (rs.next()) {
              categories.put(rs.getString(1), rs.getString(2));
              }
            }
          finally { rs.close(); }
          }
        finally {s.close(); }
        }
      catch (SQLException e) {
        System.out.println("Could not get categories: " + e.getMessage());
        }
      finally {
        dataManager.putConnection(connection);
        }
      }
    return categories;
    }
  }

