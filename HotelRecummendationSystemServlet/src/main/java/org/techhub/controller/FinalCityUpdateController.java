package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.techhub.model.CityModel;
import org.techhub.services.CityService;

@WebServlet("/finalcity")
public class FinalCityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("cityname");
		CityModel model = new CityModel();
		model.setCid(cid);
		model.setCityname(name);
		boolean b = new CityService().isUpdateCity(model);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("viewcity");
			r.forward(request, response);
		} else {
			out.println("\"<script>alert('Some problem in City updating');</script>\"");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}