package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatehotel")
public class UpdateHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		int hid = Integer.parseInt(request.getParameter("hotelId"));
		String name = request.getParameter("hotelName");

		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='CSS/addhotel.css' />");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Update Hotel</h2>");
		out.println("<form name='frm' action='finalupdate' method='POST'>");
		out.println("<label for=''></label><br>");
		out.println("<input type='hidden' id='hotelName' name='id' value='" + hid
				+ "'  placeholder='Enter hotel name' required><br><br>");
		out.println("<label for='hotelName'>Hotel Name:</label><br>");
		out.println("<input type='text' id='hotelName' name='name' value=''" + name
				+ "' placeholder='Enter hotel name' required><br><br>");
		out.println("<button type='submit' name='s'>Update Hotel</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
