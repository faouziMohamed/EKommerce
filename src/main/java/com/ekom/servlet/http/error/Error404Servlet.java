package com.ekom.servlet.http.error;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Error404Servlet", value = "/404")
public class Error404Servlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
    IOException {
    this.getServletContext().getRequestDispatcher("/WEB-INF/http-errors/404.jsp").forward(request, response);
  }
}
