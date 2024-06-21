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
import org.techhub.model.HotelModel;
import org.techhub.services.HotelService;

@WebServlet("/hotelinfo")
public class AddHotelInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Hotel Information</title>");
		out.println("<link rel='stylesheet' href='CSS/addhotelinfo.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<label for='gmail'>Gmail:</label>");
		out.println(" <input type='email' id='email' name='gmail' required>");
		out.println(" <label for='contact'>Contact:</label>");
		out.println("<input type='tel' id='phone' name='contact' required>");
		out.println(" <label for='location'>Location:</label>");
		out.println(" <input type='text' id='name' name='location' required>");
		out.println(" <label for='address'>Address:</label>");
		out.println(" <input type='text' id='message' name='address' required>");
		HotelService hotelServ = new HotelService();
		List<HotelModel> list = hotelServ.getAllHotels();
		out.println("<label for='hotelname'>HotelName:</label>");
		out.println("<select id='category' name='hotelname' required>");
		out.println("<option>Select Hotel</option>");
		for (HotelModel model : list) {
			out.println("<option>" + model.getName() + "</option>");
		}
		out.println("</select>");
		out.println("<input type='submit' name='s' value='Add Hotel Info'>");
		out.println("</form>");
		out.println("</div>");
		String btn = request.getParameter("s");
		if (btn != null) {
			String gmail = request.getParameter("gmail");
			String contact = request.getParameter("contact");
			String location = request.getParameter("location");
			String address = request.getParameter("address");
			String hotelName = request.getParameter("hotelname");
			HotelInfoModel model = new HotelInfoModel();
			model.setGmail(gmail);
			model.setContact(contact);
			model.setLocation(location);
			model.setAddress(address);
			model.setName(hotelName);
			HotelService hServ = new HotelService();
			boolean b = hServ.isAddInfoHotel(model);
			if (b) {
				out.println("<script>alert('Hotel Info Added successfully');</script>");
			} else {
				out.println("<script>alert('Something went wrong');</script>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
