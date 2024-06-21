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
import org.techhub.model.CityModel;
import org.techhub.services.CityService;

@WebServlet("/viewcity")
public class ViewCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			RequestDispatcher navbarDispatcher = request.getRequestDispatcher("navbar.html");
			navbarDispatcher.include(request, response);

			CityService cityService = new CityService();
			List<CityModel> list = cityService.getAllCities();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='CSS/viewhotel.css'>");
			out.println("</head>");
			out.println("<body>");

			out.println("<table>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>City Name</th>");
			out.println("<th>Delete</th>");
			out.println("<th>Update</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			for (CityModel c : list) {
				out.println("<tr>");
				out.println("<td>" + c.getCityname() + "</td>");
				out.println("<td><a href='deletecity?cid=" + c.getCid() + "'>Delete</a></td>");
				out.println("<td><a href='updatecity?cid=" + c.getCid() + "&cityname=" + c.getCityname() + "'>Update</a></td>");
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("An error occurred while processing your request.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
