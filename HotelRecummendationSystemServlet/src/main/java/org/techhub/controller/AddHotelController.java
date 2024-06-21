package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.HotelModel;
import org.techhub.services.HotelService;

@WebServlet("/newhotel")
public class AddHotelController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='CSS/addhotel.css'>");
        out.println("</head>");
        out.println("<body>");
        RequestDispatcher r = request.getRequestDispatcher("navbar.html");
        r.include(request, response);
        out.println("<h2>Add Hotel</h2>");
        out.println("<form name='frm' action='' method='POST'>");
        out.println("<label for='hotelName'>Hotel Name:</label><br>");
        out.println("<input type='text' id='hotelName' name='name' placeholder='Enter hotel name' required><br><br>");
        out.println("<button type='submit' name='s'>Add Hotel</button>");
        out.println("</form>");
        out.println("</body>"); 
        out.println("</html>"); 
        String btn = request.getParameter("s");
        if (btn != null) {
            String hotelName = request.getParameter("name");
            HotelModel model = new HotelModel();
            model.setName(hotelName);
            HotelService hotelServ = new HotelService();
            boolean b = hotelServ.isAddHotel(model);
            
            if (b) {
                out.println("<script>alert('Hotel Added successfully');</script>");
            } else {
                out.println("<script>alert('Something went wrong');</script>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); 
    }
}
