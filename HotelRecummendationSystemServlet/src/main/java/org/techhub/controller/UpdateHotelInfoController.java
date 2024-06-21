package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatehotelinfo")
public class UpdateHotelInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		int Iid = Integer.parseInt(request.getParameter("iid"));
		String Gmail = request.getParameter("gmail");
		String Contact = request.getParameter("contact");
		String Location = request.getParameter("location");
		String Address = request.getParameter("address");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='CSS/addhotelinfo.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<form name='frm' action='finalupdateinfo' method='POST'>");
		out.println("<label for=''></label>");
		out.println("<input type='hidden' name='iid' value='" + Iid + "'required>");
		out.println("<label for='Gmail'>Gmail:</label>");
		out.println("<input type='text' name='gmail' value='" + Gmail + "'required>");
		out.println("<label for='Contact'>Contact:</label>");
		out.println("<input type='text' name='contact' value='" + Contact + "'required>");
		out.println("<label for='Location'>Location:</label>");
		out.println("<input type='text' name='location' value='" + Location + "'required>");
		out.println("<label for='Address'>Address:</label>");
		out.println("<input type='text' name='address' value='" + Address + "' required>");
		out.println("<input type='submit' name='s' value='Update Hotel Info'>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}