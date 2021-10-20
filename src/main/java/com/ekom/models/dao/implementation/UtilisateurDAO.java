package com.ekom.models.dao.implementation;

import com.ekom.exception.AuthException;
import com.ekom.models.beans.Utilisateur;
import com.ekom.models.dao.DAOFactory;
import com.ekom.models.dao.IUtilisateurDAO;
import com.ekom.utils.Utils;

import java.sql.*;
import java.util.ArrayList;

public class UtilisateurDAO extends DAOCommon implements IUtilisateurDAO {
  public UtilisateurDAO(DAOFactory daoFactory) {
    super(daoFactory);
  }

  @Override
  public void initiateDatabase() throws SQLException {
    try {
      createTable();
      Utilisateur[] users = {new Utilisateur("Faouzi", "Mohamed", "faouzi@email.com", "1234"),
        new Utilisateur("Haggar", "Haggar", "haggar@email.com", "1234"),
        new Utilisateur("John", "Doe", "john@email.com", "1234"),
        new Utilisateur("admin", "Admin", "admin@email.com", "admin")};

      for (Utilisateur u : users) {
        addUser(u);
      }
    } catch (Exception ignore) {
    }
  }

  @Override
  public void createTable() {
    try {
      Connection con = daoFactory.getConnection();
      String query;
      query = "" +
        "CREATE TABLE IF NOT EXISTS users (" +
        "    uid      VARCHAR(255) UNIQUE NOT NULL," +
        "    email    VARCHAR(255) UNIQUE NOT NULL," +
        "    password VARCHAR(255)        NOT NULL," +
        "    nom      VARCHAR(255)        NOT NULL," +
        "    prenom   VARCHAR(255)        NOT NULL," +
        "    PRIMARY KEY (email, uid)" +
        ") ENGINE = INNODB;";

      PreparedStatement st = con.prepareStatement(query);
      st.executeUpdate();

    } catch (SQLException e) {
      System.out.println("An error occurred while trying to create user table: ");
      e.printStackTrace();
    }
  }

  @Override
  public void addUser(Utilisateur user) {
    String userId = Utils.generateIdFromObj(user);
    try {
      Connection con = daoFactory.getConnection();
      String query = "INSERT INTO users (uid, nom, prenom,email, password) VALUES(?, ?, ?, ?, ?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, userId);
      ps.setString(2, user.getNom());
      ps.setString(3, user.getPrenom());
      ps.setString(4, user.getEmail());
      ps.setString(5, user.getPassword());
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
      if (result.next()) {
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

  @Override
  public Utilisateur authentifier(String email, String password) throws AuthException {
    if (email == null) {
      throw new AuthException("Un email est requise mais rien n'a été passé");
    }
    if (password == null) {
      throw new AuthException("Veuillez tapez un mot de passe");
    }

    Utilisateur u = getUserByEmail(email);

    if (u == null) {
      throw new AuthException("Email non trouvé");
    }

    if (!u.getPassword().equals(password)) {
      throw new AuthException("Mot de passe incorrect");
    }
    return u;
  }

}
