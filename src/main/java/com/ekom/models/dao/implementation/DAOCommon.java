package com.ekom.models.dao.implementation;

import com.ekom.models.dao.DAOFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAOCommon {
  protected final DAOFactory daoFactory;

  public DAOCommon(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

  public boolean tableExists(String tableName) throws SQLException {
    Connection connection = daoFactory.getConnection();
    DatabaseMetaData meta = connection.getMetaData();
    ResultSet resultSet = meta.getTables(null, null, tableName, new String[]{"TABLE"});
    System.out.println("UtilisateurDAO.tableExists");
    return resultSet.next();
  }

  public boolean isTableEmpty(String tableName) throws SQLException {
    Connection connexion = daoFactory.getConnection();
    ResultSet resultSet;
    int count = 0;

    try {
      resultSet = connexion.createStatement().executeQuery("SELECT COUNT(*) count FROM " + tableName);
      if (resultSet.next()) count = resultSet.getInt("count");

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return count == 0;
  }

  abstract public void initiateDatabase() throws SQLException;
  abstract public void createTable();
}
