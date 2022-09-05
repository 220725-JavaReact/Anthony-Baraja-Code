package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet{

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
        
        System.out.println("Order Menu -> GET");
        resp.setContentType("text/html");
        resp.getWriter().write("<header><title>Order Main Menu</title></header><body><h1><strong>Order Main Menu</strong></h1>");

        // Selection 1: Place an Order
		resp.getWriter().write("<form method = \"get\" action = \"/storeapp/placeOrder\">\r\n"
            + "<p><strong>Place an Order</strong></p>\r\n"
            + "<input type = \"submit\" value = \"Place Order\"/></form>");
        
        // Selection 2: View Order History
		resp.getWriter().write("<form method = \"get\" action = \"/storeapp/orderHistory\">\r\n"
            + "<p><strong>View Order History</strong></p>\r\n"
            + "<input type = \"submit\" value = \"view order history\"/></form>");
        
        resp.getWriter().write("</body>");

    }
}
