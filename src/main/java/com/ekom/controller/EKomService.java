package com.ekom.controller;

import com.ekom.exception.AuthException;
import com.ekom.exception.IncorrectUserException;
import com.ekom.exception.UserNotFoundException;
import com.ekom.model.Utilisateur;

import java.util.TreeMap;


public final class EKomService {
  static private TreeMap<String, Utilisateur> users = null;

  public EKomService() {
    users = new TreeMap<>();
    Utilisateur[] utilisateurs = {
      new Utilisateur("Faouzi", "Mohamed", "faouzi@email.com", "1234"),
      new Utilisateur("Haggar", "Haggar", "haggar@email.com", "1234"),
      new Utilisateur("John", "Doe", "john@email.com", "1234"),
      new Utilisateur("admin", "Admin", "admin@email.com", "admin")
    };

    for (Utilisateur u : utilisateurs) {
      users.put(u.getEmail(), u);
    }
  }

  public static Utilisateur authentifier(String email, String password) throws AuthException {
    Utilisateur u = users.get(email);
    if (u == null) {
      throw new AuthException("Email non trouvé");
    }

    if (!u.getPassword().equals(password)) {
      throw new AuthException("Mot de passe incorrect");
    }
    return u;
  }

  public static Utilisateur findUser(Utilisateur utilisateur) throws UserNotFoundException, IncorrectUserException {
    if (utilisateur == null) {
      throw new IncorrectUserException();
    }
    Utilisateur user = users.get(utilisateur.getNom());
    if (user == null) {
      throw new UserNotFoundException();
    }
    return user;
  }

  public static Utilisateur findUser(String email) throws UserNotFoundException, IncorrectUserException {
    Utilisateur user = users.get(email);
    return findUser(user);
  }
}
