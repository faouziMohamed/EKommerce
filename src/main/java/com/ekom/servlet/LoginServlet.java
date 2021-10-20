package com.ekom.servlet;

import com.ekom.exception.AuthException;
import com.ekom.models.dao.implementation.UtilisateurDAO;
import com.ekom.models.beans.Utilisateur;
import com.ekom.servlet.controller.EKomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private EKomService eKomService;

  public void init() {
    eKomService = EKomService.getInstance();
    UtilisateurDAO udao = eKomService.getUtilisateurDAO();
    try {
      if (!udao.tableExists("users") || udao.isTableEmpty("users")) {
        udao.initiateDatabase();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    HttpSession session = request.getSession();
    System.out.println(email);
    try {
      Utilisateur u = eKomService.authentifier(email, password);
      System.out.println(u.getEmail());
      session.setAttribute("user", u);
      response.sendRedirect("/products");

    } catch (AuthException e) {
      request.setAttribute("error", e.getMessage());
      doGet(request, response);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    Utilisateur user = (Utilisateur) session.getAttribute("user");
//    eKomService.getUtilisateurDAO().getUsers().forEach(System.out::println);
    if (user != null) {
      response.sendRedirect("/products");
      return;
    }
    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
  }

}
