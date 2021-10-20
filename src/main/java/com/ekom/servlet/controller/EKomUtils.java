package com.ekom.servlet.controller;

import com.ekom.exception.NoUserConnectedException;
import com.ekom.exception.ParamMissingException;
import com.ekom.exception.UserNotFoundException;
import com.ekom.models.beans.Utilisateur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class EKomUtils {

  static public String getPathParam(String pathInfo) throws ParamMissingException {
    String id;
    try {
      id = pathInfo.split("/")[1];
    } catch (ArrayIndexOutOfBoundsException e) {
      String msg = "ID du produit manquant: L'Id du produit à éditer est attendu mais rien n'a été donner";
      throw new ParamMissingException(msg);
    }
    return id;
  }

  public static void verifyExistsSessionOrThrow(HttpServletRequest req) throws NoUserConnectedException {
    try {
      getCurrentUser(req);
    } catch (UserNotFoundException e) {
      throw new NoUserConnectedException();
    }
  }

  public static Utilisateur getCurrentUser(HttpServletRequest request) throws UserNotFoundException {
    HttpSession session = request.getSession(false);
    Utilisateur user;
    try {
      user = (Utilisateur) session.getAttribute("user");
    } catch (NullPointerException e) {
      throw new UserNotFoundException();
    }
    return user;
  }
}
