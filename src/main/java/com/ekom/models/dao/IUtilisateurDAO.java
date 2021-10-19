package com.ekom.models.dao;

import com.ekom.models.beans.Utilisateur;

import java.util.ArrayList;

public interface IUtilisateurDAO {
  void addUser(Utilisateur user);

  ArrayList<Utilisateur> getUsers();

  Utilisateur getUserByEmail(String email);

}
