package com.ekom.models;

import com.ekom.models.beans.Utilisateur;
import com.ekom.models.dao.DAOFactory;
import com.ekom.models.dao.IUtilisateurDAO;

import java.sql.*;
import java.util.ArrayList;

public class UtilisateurDAO implements IUtilisateurDAO {
  private final DAOFactory daoFactory;

  public UtilisateurDAO(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

  @Override
  public void addUser(Utilisateur user) {
    try {
      Connection con = daoFactory.getConnection();
      String query = "INSERT INTO users (nom, prenom,email, password) VALUES(?, ?, ?, ?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, user.getNom());
      ps.setString(2, user.getPrenom());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error in adding user query: ");
      e.printStackTrace();
    }

  }

  @Override
  public ArrayList<Utilisateur> getUsers() {
    ArrayList<Utilisateur> users = new ArrayList<>();
    try {
      Connection con = daoFactory.getConnection();
      Statement statement = con.createStatement();
      ResultSet result = statement.executeQuery("SELECT nom, prenom, email, password FROM users");
      while (result.next()) {
        String nom = result.getString("nom");
        String prenom = result.getString("prenom");
        String email = result.getString("email");
        String password = result.getString("password");
        users.add(new Utilisateur(nom, prenom, email, password));
      }
    } catch (SQLException e) {
      System.out.println("An error appear when trying to get all users");
      System.out.println("Cause : ");
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public Utilisateur getUserByEmail(String email) {

    Utilisateur user = null;
    try {
      Connection con = daoFactory.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT nom, prenom, email, password FROM users WHERE email = ?");
      ps.setString(1, email);
      ResultSet result = ps.executeQuery();
      if (result.first()) {
        String nom = result.getString("nom");
        String prenom = result.getString("prenom");
        String email1 = result.getString("email");
        String password = result.getString("password");
        user = new Utilisateur(nom, prenom, email1, password);
      }
    } catch (SQLException e) {
      System.out.println("An error appear when trying to get user by email");
      System.out.println("Cause : ");
      e.printStackTrace();
    }
    return user;
  }

}
