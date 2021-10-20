package com.ekom.servlet;

import com.ekom.exception.NoUserConnectedException;
import com.ekom.exception.ParamMissingException;
import com.ekom.servlet.controller.EKomUtils;

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
      EKomUtils.verifyExistsSessionOrThrow(request);
      String pathInfo = request.getPathInfo();
      String productId = EKomUtils.getPathParam(pathInfo);
      request.setAttribute("pid", productId);

      getServletContext()
        .getRequestDispatcher("/WEB-INF/edit-product.jsp")
        .forward(request, response);
    } catch (NoUserConnectedException e) {
      response.sendError(401);
    } catch (ParamMissingException e) {
      response.setContentType("text/json");
      response.setCharacterEncoding("UTF-8");
      PrintWriter pw = response.getWriter();
      pw.print("{\"error\": \"" + e.getMessage() + "\"}");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
