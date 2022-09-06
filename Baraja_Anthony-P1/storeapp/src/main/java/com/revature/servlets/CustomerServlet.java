package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet{

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Customer Menu -> GET");
		resp.setContentType("text/html");
		resp.getWriter().write("<header><title>Customer Main Menu</title></header><body><nav><a href=\"./index.html\">Home</a></nav><h1><strong>Customer Main Menu</strong></h1>");

		// Selection 1: View All Customers
		resp.getWriter().write("<form method = \"get\" action = \"/storeapp/allCustomers\">\r\n"
			+ "<p><strong>View All Customers</strong></p>\r\n"
			+ "<input type = \"submit\" value = \"view all customers\"/></form>");


		// Selection 2: Search a customer
		resp.getWriter().write("<form method = \"get\" action = \"/storeapp/searchCustomer\">\r\n"
			+ "<p><strong>Search a Customer</strong></p>\r\n"
			+ "<input type = \"submit\" value = \"search customer\"/></form>");
		
		
		// Selection 3: Add a customer
		resp.getWriter().write("<form method = \"get\" action = \"/storeapp/addCustomer\">\r\n"
			+ "<p><strong>Add Customer</strong></p>\r\n"
			+ "<input type = \"submit\" value = \"add customer\"/></form>");

		
		resp.getWriter().write("</body>");
	}
    
}
