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
		resp.getWriter().write("<header><title>Customer Main Menu</title></header><body><h1><strong>Customer Main Menu</strong></h1></body>");
		
	
	}
    
}
