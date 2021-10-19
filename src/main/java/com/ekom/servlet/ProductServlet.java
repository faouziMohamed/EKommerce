package com.ekom.servlet;

import com.ekom.exception.NoUserConnectedException;
import com.ekom.servlet.controller.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Utils.verifyExistsSessionOrThrow(request);
      getServletContext().getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    } catch (NullPointerException | NoUserConnectedException e) {
      response.sendRedirect(request.getContextPath() + "/login");
    }
  }
}
