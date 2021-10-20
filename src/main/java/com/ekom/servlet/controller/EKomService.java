package com.ekom.servlet.controller;

import com.ekom.exception.AuthException;
import com.ekom.models.users.UtilisateurDAOMy;
import com.ekom.models.beans.Utilisateur;
import com.ekom.models.dao.DAOMyFactory;


public class EKomService {

  private static final EKomService eKomService = new EKomService();
  private final UtilisateurDAOMy utilisateurDAO;

  private EKomService() {
    utilisateurDAO = DAOMyFactory.getInstance().getUtilisateurDAO();
  }

  public UtilisateurDAOMy getUtilisateurDAO() {
    return utilisateurDAO;
  }

  public static EKomService getInstance() {
    return eKomService;
  }

  public Utilisateur authentifier(String email, String password) throws AuthException {
    return utilisateurDAO.authentifier(email, password);
  }

}
