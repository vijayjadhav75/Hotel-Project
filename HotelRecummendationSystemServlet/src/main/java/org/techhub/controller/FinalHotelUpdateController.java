package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.HotelModel;
import org.techhub.services.HotelService;

@WebServlet("/finalupdate")
public class FinalHotelUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int hotelId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		HotelModel model = new HotelModel();
		model.setId(hotelId);
		model.setName(name);
		boolean b = new HotelService().isUpdateHotel(model);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("view");
			r.forward(request, response);
		} else {
			out.println("\"<script>alert('Some problem in hotel updating');</script>\"");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}