package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.businessLogic.BusinessLogic;

public class SearchCustomerServlet extends HttpServlet {

    private static BusinessLogic bl = new BusinessLogic();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Search Customer -> GET");
		resp.setContentType("text/html");
		resp.getWriter().write("<header><title>Search a Customer</title></header><nav><a href=\"./index.html\">Home</a></nav><body><h1><strong>Search a Customer</strong></h1>");

		// Display text box and submit button
		resp.getWriter().write("<form method = \"post\" action = \"/storeapp/searchCustomer\">\r\n"
			+ "Enter Name: <input type = \"text\" name = \"customer_name\" placeholder=\"customer name\" />\r\n"
			+ "<input type = \"submit\" value = \"search customer\"/></form>");


        resp.getWriter().write("</body>");
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
        
        String name = req.getParameter("customer_name");

		resp.setContentType("text/html");
		resp.getWriter().write("<header><title>Search a Customer</title></header><nav><a href=\"./index.html\">Home</a></nav><body>");
        
        // Display Searched Customer if exist in DB
        resp.getWriter().write(bl.displaySearchedCustomer(name));

		resp.getWriter().write("</body>");

    }
    
}
