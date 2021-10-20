package com.ekom.models.dao;

import com.ekom.models.products.ProduitDAOMy;
import com.ekom.models.users.UtilisateurDAOMy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOMyFactory {
  static private DAOMyFactory instance;
  static private Connection con;


  private DAOMyFactory(String url, String user, String password) throws SQLException {
    con = DriverManager.getConnection(url, user, password);
  }

  public static DAOMyFactory getInstance() {
    try {
      if (instance == null) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        instance = new DAOMyFactory("jdbc:mysql://127.0.0.1:3306/ekomerce", "ekom", "ekom");
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

  public UtilisateurDAOMy getUtilisateurDAO() {
    return new UtilisateurDAOMy(this);
  }

  public ProduitDAOMy getProduitDAO(){
    return new ProduitDAOMy(this);
  }
}
