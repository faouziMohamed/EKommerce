package com.ekom.servlet.api;

import com.ekom.controller.Utils;
import com.ekom.exception.UserNotFoundException;
import com.ekom.model.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserApiServlet", value = "/api/user")
public class UserApiServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Utilisateur user = Utils.getCurrentUser(request);
    } catch (UserNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}