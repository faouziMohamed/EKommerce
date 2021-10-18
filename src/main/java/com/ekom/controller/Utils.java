package com.ekom.controller;

import com.ekom.exception.ParamMissingException;
import com.ekom.exception.UserNotFoundException;
import com.ekom.model.Utilisateur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
  public static Utilisateur getCurrentUser(HttpServletRequest request) throws UserNotFoundException {
    HttpSession session = request.getSession(false);
    Utilisateur user = (Utilisateur) session.getAttribute("user");
    if (user == null) {
      throw new UserNotFoundException();
    }
    return user;
  }

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
}
