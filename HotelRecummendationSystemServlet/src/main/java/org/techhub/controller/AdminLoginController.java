package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.LoginModel;
import org.techhub.services.AdminLoginService;

@WebServlet("/adminlogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginModel model = new LoginModel();
		model.setUsername(username);
		model.setPassword(password);
		AdminLoginService adService = new AdminLoginService();
		boolean b = adService.isAdminLogin(model);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("navbar.html");
			r.forward(request, response);
			out.println("<h1 style='color:red;'> username and password</h1>");
		} else {
			RequestDispatcher r = request.getRequestDispatcher("LoginAdmin.html");
			r.forward(request, response);
			out.println("<h1 style='color:red;'>Invalid username and password</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}