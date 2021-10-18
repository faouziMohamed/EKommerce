package com.ekom.servlet;

import com.ekom.controller.EKomService;
import com.ekom.exception.AuthException;
import com.ekom.model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    HttpSession session = request.getSession();

    try {
      Utilisateur u = EKomService.authentifier(email, password);
      session.setAttribute("user", u);
      getServletContext()
        .getRequestDispatcher("/WEB-INF/products.jsp")
        .forward(request, response);
      // Rediriger vers la page principale
      // response.sendRedirect(mainPage);
    } catch (AuthException e) {
      getServletContext()
        .getRequestDispatcher("/WEB-INF/products.jsp")
        .forward(request, response);
      e.printStackTrace();
      session.setAttribute("error", e.getMessage());
      // Afficher l'erreur dans le client
//      doGet(request, response);
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

}
