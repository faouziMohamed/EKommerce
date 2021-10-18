package com.ekom.servlet;

import com.ekom.controller.Utils;
import com.ekom.exception.ParamMissingException;
import com.ekom.exception.UserNotFoundException;
import com.ekom.model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditProductServlet", value = "/product/edit/*")
public class EditProductServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Utilisateur user = Utils.getCurrentUser(request);
      String pathInfo = request.getPathInfo();
      String productId = Utils.getPathParam(pathInfo);
      request.setAttribute("user", user);
      request.setAttribute("pid", productId);

      getServletContext()
        .getRequestDispatcher("/WEB-INF/edit-product.jsp")
        .forward(request, response);
    } catch (UserNotFoundException e) {
      getServletContext()
        .getRequestDispatcher("/WEB-INF/edit-product.jsp")
        .forward(request, response);
//      response.sendRedirect(request.getContextPath() + "/login");

    } catch (ParamMissingException e) {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      pw.print(e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
