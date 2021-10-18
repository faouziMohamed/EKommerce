package com.ekom.servlet;

import com.ekom.exception.UserNotFoundException;
import com.ekom.model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ekom.controller.Utils.getCurrentUser;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Utilisateur user = getCurrentUser(request);
      request.setAttribute("user", user);
      getServletContext().getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    } catch (UserNotFoundException | NullPointerException e) {
      request.setAttribute("error", "Vous devez vous connecter pour continuer");
      getServletContext()
        .getRequestDispatcher("/WEB-INF/products.jsp")
        .forward(request, response);

//      response.sendRedirect(request.getContextPath() + "/login");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
