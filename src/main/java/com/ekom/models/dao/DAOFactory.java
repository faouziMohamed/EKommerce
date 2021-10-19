package com.ekom.models.dao;

import com.ekom.models.UtilisateurDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
  static private DAOFactory instance;
  static private Connection con;

  private DAOFactory(String url, String user) throws SQLException {
    this(url, user, "");
  }

  private DAOFactory(String url, String user, String password) throws SQLException {
    con = DriverManager.getConnection(url, user, password);
  }

  public static DAOFactory getInstance() {
    try {
      if (instance == null) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        instance = new DAOFactory("jdbc:mysql://127.0.0.1:3306/ekomerce", "ekom", "ekom");
      }
    } catch (ClassNotFoundException e) {
      System.out.println("Error in loading Mysql Server driver");
    } catch (SQLException e) {
      System.out.println("Error making database connection");
    }
    return instance;
  }

  public Connection getConnection() {
    return con;
  }

  public UtilisateurDAO getUtilisateurDAO() {
    return new UtilisateurDAO(this);
  }
}
