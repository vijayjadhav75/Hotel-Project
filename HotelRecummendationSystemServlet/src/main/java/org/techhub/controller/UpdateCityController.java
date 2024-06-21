package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatecity")
public class UpdateCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cityname = request.getParameter("cityName");

		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='CSS/addhotel.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Update City</h2>");
		out.println("<form name='frm' action='finalcity' method='POST'>");
		out.println("<label for='cid'></label><br>");
		out.println("<input type='hidden' id='cityId' name='cid' value='" + cid
				+ "'><br><br>");
		out.println("<label for='cityName'>City Name:</label><br>");
		out.println("<input type='text' id='cityName' name='cityname' value=''" + cityname
				+ "'><br><br>");
		out.println("<button type='submit' name='s'>Update City</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
