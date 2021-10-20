package com.ekom.servlet.controller;

import com.ekom.exception.AuthException;
import com.ekom.models.dao.implementation.UtilisateurDAO;
import com.ekom.models.beans.Utilisateur;
import com.ekom.models.dao.DAOFactory;


public class EKomService {

  private static final EKomService eKomService = new EKomService();
  private final UtilisateurDAO utilisateurDAO;

  private EKomService() {
    utilisateurDAO = DAOFactory.getInstance().getUtilisateurDAO();
  }

  public UtilisateurDAO getUtilisateurDAO() {
    return utilisateurDAO;
  }

  public static EKomService getInstance() {
    return eKomService;
  }

  public Utilisateur authentifier(String email, String password) throws AuthException {
    return utilisateurDAO.authentifier(email, password);
  }

}
