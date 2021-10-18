package com.ekom.servlet.http.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Error401Servlet", value = "/401")
public class Error401Servlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
    IOException {
    this.getServletContext().getRequestDispatcher("/WEB-INF/http-errors/401.jsp").forward(request, response);
  }
}
