package com.ekom.servlet.api;

import com.ekom.exception.UserNotFoundException;
import com.ekom.models.beans.Utilisateur;
import com.ekom.servlet.controller.EKomUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserApiServlet", value = "/api/user")
public class UserApiServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Utilisateur user = EKomUtils.getCurrentUser(request);
      request.getSession().setAttribute("user", user);
    } catch (UserNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
