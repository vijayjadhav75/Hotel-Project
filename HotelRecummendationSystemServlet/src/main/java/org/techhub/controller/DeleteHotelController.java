package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.services.HotelService;

@WebServlet("/del")
public class DeleteHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int hid = Integer.parseInt(request.getParameter("hotelId"));
		boolean b = new HotelService().isDeleteHotel(hid);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("view");
			r.forward(request, response);
		} else {
			out.println("<script>alert('Something went wrong');</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
