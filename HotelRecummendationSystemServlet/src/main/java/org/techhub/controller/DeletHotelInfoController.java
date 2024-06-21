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

@WebServlet("/deleteinfo")
public class DeletHotelInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int Iid = Integer.parseInt(request.getParameter("iid"));
		boolean b = new HotelService().isDeleteHotelInfo(Iid);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("viewhotelinfo");
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