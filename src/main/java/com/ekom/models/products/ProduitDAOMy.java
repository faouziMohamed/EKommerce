package com.ekom.models.products;

import com.ekom.models.beans.Produit;
import com.ekom.models.dao.DAOMyCommon;
import com.ekom.models.dao.DAOMyFactory;

import java.sql.*;
import java.util.ArrayList;

public class ProduitDAOMy extends DAOMyCommon implements IProduitDAO {

  public ProduitDAOMy(DAOMyFactory daoMyFactory) {
    super(daoMyFactory);
  }

  public void initiateDatabase() throws SQLException {
    createTable();
    Produit[] produits = {
      new Produit(null, "Apple Iphone 12 pro", 150, 10005.25,
        "https://images.frandroid.com/wp-content/uploads/2020/10/iphone-12-max-frandroid-2020.png",
        "Some quick example text to build on the card title and make up the" +
          "bulk of the card's content."
      )
    };

    for (Produit p : produits) {
      addProduit(p);
    }

/*
bar
"https://images.frandroid.com/wp-content/uploads/2020/10/iphone-12-max-frandroid-2020.png"
name: Apple Iphone 12 pro
prix: 12euro
desc: Some quick example text to build on the card title and make up the
      bulk of the card's content.

"https://virginmegastore.ma/storage/2017/10/5.jpg"
Apple Iphone 12 pro

"https://images.frandroid.com/wp-content/uploads/2020/10/iphone-12-frandroid-2020.png"


"https://www.cdiscount.com/pdt2/0/3/4/1/700x700/ap0194252136034/rw/apple-iphone-12-pro-128go-bleu-pacifique.jpg"


* */

  }

  @Override
  public void createTable() {
    try {
      Connection con = daoMyFactory.getConnection();
      String query;
      query = "" +
        "CREATE TABLE produits" +
        "(" +
        "    pid         VARCHAR(50)  NOT NULL PRIMARY KEY," +
        "    nom         VARCHAR(255) NOT NULL," +
        "    qte         INTEGER      NOT NULL DEFAULT 0," +
        "    prix        NUMERIC      NOT NULL," +
        "    urlImage    VARCHAR(255) NOT NULL," +
        "    description LONGTEXT     NOT NULL" +
        ") ENGINE = INNODB;";

      Statement st = con.createStatement();
      st.executeQuery(query);
    } catch (SQLException e) {
      System.out.println("An error occurred while trying to create product table: ");
      e.printStackTrace();
    }
  }

  @Override
  public void addProduit(Produit p) {
    try {
      Connection con = daoMyFactory.getConnection();
      String query = "" +
        "INSERT " +
        "INTO produits (pid, nom, qte,prix, urlImage, description) " +
        "VALUES(?, ?, ?, ?, ?, ?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, p.getId());
      ps.setString(2, p.getNom());
      ps.setInt(3, p.getQte());
      ps.setDouble(4, p.getPrix());
      ps.setString(5, p.getUrlImage());
      ps.setString(6, p.getDescription());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error in adding user query: ");
      e.printStackTrace();
    }
  }

  @Override
  public void removeProduit(String pid) {
    try {
      Connection con = daoMyFactory.getConnection();
      String query = "DELETE FROM produits WHERE pid = ?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, pid);
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error in adding user query: ");
      e.printStackTrace();
    }
  }

  @Override
  public void updateOneProduit(String pid, String column, Object newValue) {
    try {
      Connection con = daoMyFactory.getConnection();
      String query = "UPDATE produits SET ? = ?  WHERE pid = ?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, column);
      ps.setObject(2, newValue);
      ps.setString(3, pid);
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error in adding user query: ");
      e.printStackTrace();
    }
  }

  @Override
  public Produit getProduitById(String pid) throws SQLException {

    Produit produit = null;
    try {
      Connection con = daoMyFactory.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM produits WHERE pid = ?");
      ps.setString(1, pid);
      ResultSet result = ps.executeQuery();
      if (result.next()) {
        String nom = result.getString("nom");
        int qte = result.getInt("qte");
        double prix = result.getDouble("prix");
        String urlImage = result.getString("urlImage");
        String description = result.getString("description");
        produit = new Produit(pid, nom, qte, prix, urlImage, description);
      }
    } catch (SQLException e) {
      System.out.println("An error appear when trying to get user by email");
      System.out.println("Cause : ");
      e.printStackTrace();
    }

    return produit;
  }

  @Override
  public ArrayList<Produit> getProduitsByName(String name) {

    ArrayList<Produit> produits = new ArrayList<>();
    try {
      Connection con = daoMyFactory.getConnection();
      Statement statement = con.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM produits where nom = ?");
      while (result.next()) {
        String nom = result.getString("nom");
        String pid = result.getString("pid");
        int qte = result.getInt("qte");
        double prix = result.getDouble("prix");
        String urlImage = result.getString("urlImage");
        String description = result.getString("description");
        produits.add(new Produit(pid, nom, qte, prix, urlImage, description));
      }
    } catch (SQLException e) {
      System.out.println("An error appear when trying to get all users");
      System.out.println("Cause : ");
      e.printStackTrace();
    }

    return produits;
  }
}
