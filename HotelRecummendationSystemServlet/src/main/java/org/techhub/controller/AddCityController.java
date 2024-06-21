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

@WebServlet("/newcity")
public class AddCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='CSS/addhotel.css' />");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		out.println("<h2>Add City</h2>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<label for='cityname'>City Name:</label><br>");
		out.println(
				"<input type='text' id='cityname' name='cityname' placeholder='Enter city name' required><br><br>");
		out.println("<button type='submit' name='s'>Add New City</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		String btn = request.getParameter("s");
		if (btn != null) {
			String cityname = request.getParameter("cityname");
			CityModel model = new CityModel();
			model.setCityname(cityname);
			CityService cityService = new CityService();
			boolean b = cityService.isAddCity(model);
			if (b) {
				out.println("<script>alert('City added succesfully')</script>");
			} else {
				out.println("<script>alert('Something went wrong')</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
