package com.ekom.models.dao;

import com.ekom.exception.AuthException;
import com.ekom.models.beans.Utilisateur;

import java.util.ArrayList;

public interface IUtilisateurDAO {
  void addUser(Utilisateur user);

  ArrayList<Utilisateur> getUsers();

  Utilisateur getUserByEmail(String email);

  public Utilisateur authentifier(String email, String password) throws AuthException;
}
