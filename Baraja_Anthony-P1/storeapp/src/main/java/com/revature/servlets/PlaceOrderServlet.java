package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.businessLogic.BusinessLogic;

public class PlaceOrderServlet extends HttpServlet{

    private static BusinessLogic bl = new BusinessLogic();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
    {
        HttpSession session =  req.getSession();

        // Pre-Params Setup if they exist
        String customerId = req.getParameter("customer_id");
        if(customerId != null){
            session.setAttribute("customer_id", customerId);
        }

        String storeId = req.getParameter("store_id");
        if(storeId != null){
            session.setAttribute("store_id", storeId);
        }

        String prodId = req.getParameter("prod_id");
        if(prodId != null){
            session.setAttribute("prod_id", prodId);
        }

        String qtyNum = req.getParameter("qty_num");
        if(qtyNum != null){
            session.setAttribute("qty_num", qtyNum);
        }

        System.out.println("Place Order -> GET; customer_id = " + session.getAttribute("customer_id") 
                         + " ; store_id = " + session.getAttribute("store_id")
                         + " ; prod_id = " + session.getAttribute("prod_id")
                         + " ; qty_num = " + session.getAttribute("qty_num"));
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        
        out.write("<header><title>Place Order</title></header><body><h1><strong>Place Order</strong></h1>");

        // Select Customer
        if(session.getAttribute("customer_id") == null && session.getAttribute("store_id") == null){
            out.write("<h2>Customer Selections:</h2>");

            out.write("<form method = \"get\" action = \"/storeapp/placeOrder\">\r\n");
            
            out.write(bl.listAllCustomerSelections());
            out.write("Select Customer: " + bl.dropDownAllCustomerSelections());
            //out.write("Enter Customer Name: <input type = \"text\" name = \"customer_name\" placeholder = \"Name\"/>\r\n");

            out.write("<h2>Store Front Selections:</h2>");
            out.write(bl.listAllStoreFrontSelections());
            out.write("Select Store: " + bl.dropDownAllStoreFrontSelections());
            //out.write("Enter Store Name: <input type = \"text\" name = \"store_name\" placeholder = \"Store Name\"/>\r\n");
            
            out.write("<input type = \"submit\" value = \"Next\"/>\r\n</form>");

        }
        else if(session.getAttribute("prod_id") == null && session.getAttribute("qty_num") == null){

            out.write("<h2>Product Selections:</h2><body>");
            
            out.write("<form method = \"get\" action = \"/storeapp/placeOrder\">\r\n");
            out.write("Select Product: " + bl.dropDownAllProductSelectionsByStoreID(Integer.parseInt(storeId)));
            out.write("Qty: <input type = \"text\" name = \"qty_num\" placeholder = \"0\"/>\r\n");
            out.write("<input type = \"submit\" value = \"Add to Cart\"/>\r\n</form>");
            
            out.write(bl.listAllProductSelectionsByStoreID(Integer.parseInt(storeId)) + "</body>");
        }
        // Direct to Cart/Receipt Servlet
        else{
            out.write("<h2>Current Cart</h2><body>");
        }

    }
    
}
