package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.businessLogic.BusinessLogic;

public class AddCustomerServlet extends HttpServlet {

    private static BusinessLogic bl = new BusinessLogic();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

        System.out.println("Add Customer -> GET");
        resp.setContentType("text/html");
        resp.getWriter().write("<header><title>Add Customer</title></header><body><h1><strong>Add Customer</strong></h1>");

        // Display text boxes and submit button	
		resp.getWriter().write("<form method = \"post\" action = \"/storeapp/addCustomer\">\r\n"
        + "<p>Enter Name: <input type = \"text\" name = \"customer_name\" placeholder=\"new customer name\" /></p>\r\n"
        + "<p>Enter Address: <input type = \"text\" name = \"customer_address\" placeholder=\"new customer address\" /></p>\r\n"
        + "<p>Enter Email: <input type = \"text\" name = \"customer_email\" placeholder=\"new customer email\" /></p>\r\n"
        + "<p>Enter Phone: <input type = \"text\" name = \"customer_phone\" placeholder=\"new customer phone\" /></p>\r\n"
        + "<p></p><input type = \"submit\" value = \"add customer\"/></form>");

    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
        
        String name = req.getParameter("customer_name");
        String address = req.getParameter("customer_address");
        String email = req.getParameter("customer_email");
        String phone = req.getParameter("customer_phone");
        
        bl.addCustomer(name, address, email, phone);
        resp.setContentType("text/html");
        resp.getWriter().write("<html><nav><a href=\"./index.html\">Home</a></nav><body><h1><strong>Customer " + name + " added successfully</strong></h1></body>");

    }
    
}
