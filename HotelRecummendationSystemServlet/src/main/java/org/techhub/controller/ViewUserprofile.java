package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.techhub.model.RegisterModel;
import org.techhub.services.UserService;

@WebServlet("/viewprofile")
public class ViewUserprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("usermaster.html");
		r.include(request,response);
		out.println("<br><br>");
		HttpSession session=request.getSession();
		Object  userId=session.getAttribute("uid");
		int loginUserId=Integer.parseInt(userId.toString());
		UserService userService=new UserService();
		RegisterModel regModel=userService.getUserProfile(loginUserId);
		if(regModel!=null) {
			out.println("<center>");
			out.println("<h1>Name is  &nbsp;&nbsp;"+regModel.getName()+"</h1>");
			out.println("<h1>Gmail is  &nbsp;&nbsp;"+regModel.getGmail()+"</h1>");
			out.println("<h1>Contact is  &nbsp;&nbsp;"+regModel.getContact()+"</h1>");
			out.println("<h1>Username is  &nbsp;&nbsp;"+regModel.getUsername()+"</h1>");
			out.println("<h1>password is  &nbsp;&nbsp;"+regModel.getPassword()+"</h1>");
			out.println("</center>");
		}else {	
			out.println("<h1>Something went wrong</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
