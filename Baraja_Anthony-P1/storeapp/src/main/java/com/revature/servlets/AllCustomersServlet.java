package com.revature.servlets;

import com.revature.businessLogic.BusinessLogic;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllCustomersServlet extends HttpServlet{
    
    private static BusinessLogic bl = new BusinessLogic();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("All Customers -> GET, All");
		resp.setContentType("text/html");
		resp.getWriter().write("<header><title>All Customers Result</title></header><nav><a href=\"./index.html\">Home</a></nav><body><h1><strong>All Customers</strong></h1>");

		// Display All Customers		
		resp.getWriter().write(bl.displayAllCustomers());

        resp.getWriter().write("</body>");
	}
    
}
