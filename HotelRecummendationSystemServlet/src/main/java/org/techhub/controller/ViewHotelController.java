package org.techhub.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.techhub.model.HotelModel;
import org.techhub.services.HotelService;

@WebServlet("/view")
public class ViewHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			RequestDispatcher navbarDispatcher = request.getRequestDispatcher("navbar.html");
			navbarDispatcher.include(request, response);

			HotelService hotelService = new HotelService();
			List<HotelModel> list = hotelService.getAllHotels();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='CSS/viewhotel.css'>");
			out.println("</head>");
			out.println("<body>");

			out.println("<table>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Delete</th>");
			out.println("<th>Update</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			for (HotelModel h : list) {
				out.println("<tr>");
				out.println("<td>" + h.getName() + "</td>");
				out.println("<td><a href='del?hotelId=" + h.getId() + "'>Delete</a></td>");
				out.println("<td><a href='updatehotel?hotelId=" + h.getId() + "&hotelName=" + h.getName()+ "'>Update</a></td>");
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// Handle exceptions gracefully, log or display an error message
			e.printStackTrace();
			out.println("An error occurred while processing your request.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
