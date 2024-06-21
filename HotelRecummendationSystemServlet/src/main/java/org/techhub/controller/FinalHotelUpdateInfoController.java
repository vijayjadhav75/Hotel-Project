package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.HotelInfoModel;
import org.techhub.services.HotelService;

@WebServlet("/finalupdateinfo")
public class FinalHotelUpdateInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int Iid = Integer.parseInt(request.getParameter("iid"));
		String Gmail = request.getParameter("gmail");
		String Contact = request.getParameter("contact");
		String Location = request.getParameter("location");
		String Address = request.getParameter("address");
		HotelInfoModel model = new HotelInfoModel();
		model.setIid(Iid);
		model.setGmail(Gmail);
		model.setContact(Contact);
		model.setLocation(Location);
		model.setAddress(Address);

		boolean b = new HotelService().isHotelInfoUpdate(model);
		if (b) {
			RequestDispatcher r = request.getRequestDispatcher("viewhotelinfo");
			r.forward(request, response);
		} else {
			out.println("<script>alert('Some problen in hotel info updating');</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}