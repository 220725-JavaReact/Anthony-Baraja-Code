package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderHistoryServlet extends HttpServlet{
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
    {
        System.out.println("Order History Menu -> GET");
        resp.setContentType("text/html");
        resp.getWriter().write("<header><title>Order History Menu</title></header><body><h1><strong>Order History Menu</strong></h1>");
        resp.getWriter().write("<body><p>Feature In Progress</p></body>");
    }
}
