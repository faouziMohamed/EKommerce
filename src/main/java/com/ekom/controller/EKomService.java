package com.ekom.controller;

import com.ekom.exception.AuthException;
import com.ekom.exception.IncorrectUserException;
import com.ekom.exception.UserNotFoundException;
import com.ekom.model.Utilisateur;

import java.util.TreeMap;


public class EKomService {
  static private TreeMap<String, Utilisateur> users = null;
  private static final EKomService eKomService = new EKomService();

  private EKomService() {
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

  public Utilisateur authentifier(String email, String password) throws AuthException {
    if (email == null) {
      throw new AuthException("Un email est requise mais rien n'a été passé");
    }
    if (password == null) {
      throw new AuthException("Veuillez tapez un mot de passe");
    }

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

  public static EKomService getInstance() {
    return eKomService;
  }
}
