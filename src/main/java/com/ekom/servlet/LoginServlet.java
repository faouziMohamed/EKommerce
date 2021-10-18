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
      Utilisateur u = EKomService.getInstance().authentifier(email, password);
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
    if (user != null) {
      response.sendRedirect("/products");
      return;
    }
    getServletContext()
      .getRequestDispatcher("/WEB-INF/index.jsp")
      .forward(request, response);
  }

}
