package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedirectPlaceOrderLoopServlet extends HttpServlet {
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
    {
        System.out.println("placeOrderLoop -> GET");
        
        //RequestDispatcher redis = req.getRequestDispatcher("/placeOrder");

        HttpSession session =  req.getSession();
        session.removeAttribute("prod_id");
        session.removeAttribute("qty_num");

		//redis.forward(req, resp);
        resp.sendRedirect("/storeapp/placeOrder");
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
    {
        System.out.println("placeOrderLoop -> POST; Clearing Session -> Redirects to /order");

        HttpSession session = req.getSession();
		// clearing the session
		session.invalidate();
        resp.sendRedirect("/storeapp/order");
    }
}
