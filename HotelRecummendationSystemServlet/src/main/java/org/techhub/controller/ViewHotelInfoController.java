package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.HotelInfoModel;
import org.techhub.services.HotelService;

@WebServlet("/viewhotelinfo")
public class ViewHotelInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		List<HotelInfoModel> list = new HotelService().getHotelList();

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
		out.println("<th>Gmail</th>");
		out.println("<th>Contact</th>");
		out.println("<th>Location</th>");
		out.println("<th>Address</th>");
		out.println("<th>Delete</th>");
		out.println("<th>Update</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("</thead>");
		for (HotelInfoModel m : list) {
			out.println("<tbody>");
			out.println("<tr font-size:'20px'>");
			out.println("<td>" + m.getName() + "</td>");
			out.println("<td>" + m.getGmail() + "</td>");
			out.println("<td>" + m.getContact() + "</td>");
			out.println("<td>" + m.getLocation() + "</td>");
			out.println("<td>" + m.getAddress() + "</td>");
			out.println("<td><a href='deleteinfo?iid=" + m.getIid() + "'>Delete</td>");
			out.println("<td><a href='updatehotelinfo?iid=" + m.getIid() + "&gmail=" + m.getGmail() + "&contact="
	                + m.getContact() + "&location=" + m.getLocation() + "&address=" + m.getAddress()
	                + "'>Update</a></td>");

		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
