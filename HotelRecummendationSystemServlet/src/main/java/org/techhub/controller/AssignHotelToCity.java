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
import org.techhub.model.HotelModel;
import org.techhub.services.CityService;
import org.techhub.services.HotelService;

@WebServlet("/assignhotel")
public class AssignHotelToCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);

		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>Hotel Dropdowns Fetch Records</title>");
		out.println("<link rel='stylesheet' href='CSS/assignhotel.css'>");
		out.println("</head>");
		out.println("<body>");

		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container'>");
		out.println("<label for='hotelname'>Hotel Name</label>");
		out.println("<select name='hotelname' id='hotelname'>");
		out.println("<option>Select Hotel</option>");
		HotelService hotelServ = new HotelService();
		List<HotelModel> list = hotelServ.getAllHotels();
		for (HotelModel model : list) {
			out.println("<option value='" + model.getId() + "'>" + model.getName() + "</option>");
		}
		out.println("</select>");

		out.println("<label for='Select City'>Select city</label>");
		out.println("<select id='Select City'>");
		out.println("<option>Select City</option>");
		List<CityModel> cityList = new CityService().getAllCities();
		for (CityModel model : cityList) {
			out.println("<option>" + model.getCityname() + "</option>");
		}
		out.println("</select>");
		out.println("<button>Assign Hotel to City</button>");
		out.println("</form>");
		String btn = request.getParameter("s");
		if (btn != null) {
			int hid = Integer.parseInt(request.getParameter("hotelname"));
			out.println(hid);
		}
		out.println("</center>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
