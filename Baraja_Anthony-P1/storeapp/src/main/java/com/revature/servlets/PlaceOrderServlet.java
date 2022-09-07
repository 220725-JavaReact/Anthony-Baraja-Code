package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.businessLogic.BusinessLogic;
import com.revature.models.Order;

public class PlaceOrderServlet extends HttpServlet{

    private static BusinessLogic bl = new BusinessLogic();
    private List<Order> fullOrder;
    ArrayList<Integer> orderQtyList;

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
            fullOrder = new ArrayList<Order>();
            orderQtyList = new ArrayList<Integer>();
            
            out.write("<h2>Customer Selections:</h2>");

            out.write("<form method = \"get\" action = \"/storeapp/placeOrder\">\r\n");
            
            out.write(bl.listAllCustomerSelections());
            out.write("Select Customer: " + bl.dropDownAllCustomerSelections());

            out.write("<h2>Store Front Selections:</h2>");
            out.write(bl.listAllStoreFrontSelections());
            out.write("Select Store: " + bl.dropDownAllStoreFrontSelections());
            
            out.write("<input type = \"submit\" value = \"Next\"/>\r\n</form>");

        }
        // Select Product
        else if(session.getAttribute("prod_id") == null && session.getAttribute("qty_num") == null){

            out.write("<h2>Product Selections:</h2><body>");

            if(session.getAttribute("qty_error_flag") != null){
                out.write("<p style=\"color:red;\">Quantity Amount not valid</p>");
                session.removeAttribute("qty_error_flag");
            }
            
            out.write("<form method = \"get\" action = \"/storeapp/placeOrder\">\r\n");
            out.write("<p>storeId: " + Integer.parseInt(String.valueOf(session.getAttribute("store_id"))) + "</p>");
            out.write("Select Product: " + bl.dropDownAllProductSelectionsByStoreID(Integer.parseInt(String.valueOf(session.getAttribute("store_id")))));
            out.write("Qty: <input type = \"text\" name = \"qty_num\" placeholder = \"0\"/>\r\n");
            out.write("<input type = \"submit\" value = \"Add to Cart\"/>\r\n</form>");
            
            out.write(bl.listAllProductSelectionsByStoreID(Integer.parseInt(String.valueOf(session.getAttribute("store_id")))) + "</body>");
        }
        // Direct to Cart/Receipt Servlet
        else{

            // Declare session params for new Order
            int currentCustomerId = Integer.parseInt(String.valueOf(session.getAttribute("customer_id")));
            int currentStoreId = Integer.parseInt(String.valueOf(session.getAttribute("store_id")));
            int currentProdId = Integer.parseInt(String.valueOf(session.getAttribute("prod_id")));
            int currentQtyNum = Integer.parseInt(String.valueOf(session.getAttribute("qty_num")));

            // QTY validation check
            if(!bl.checkUserQtyNotOverLineItemQtyLimit(currentProdId, currentQtyNum)){

                session.removeAttribute("prod_id");
                currentProdId = -1;
                session.removeAttribute("qty_num");
                currentQtyNum = -1;
                session.setAttribute("qty_error_flag", true);

                resp.sendRedirect("/storeapp/placeOrder");

            } 
            else{
                // Load it to the order List
                orderQtyList.add(currentQtyNum);

                // Calculate price of current order
                Double orderPrice = bl.setOrderPrice(currentProdId, currentQtyNum);
                System.out.println("current order price = $" + orderPrice);

                // Get an Order Link id
                int orderLinkId = bl.getNewOrderLinkId();
                
                // Create current order, load it to the full order list
                Order order = new Order(fullOrder.size() + 1, currentProdId, currentStoreId, currentCustomerId, orderLinkId, orderPrice);
                fullOrder.add(order);
                
                // Display to client
                out.write("<h2>Current Cart</h2><body>");
                out.write(bl.displayOrderDetails(fullOrder, orderQtyList));

                // Button to Keep Shopping - redirect to /placeOrder with attributes prod_id & qty_num to null
                out.write("<form method = \"get\" action = \"/storeapp/placeOrderLoop\">\r\n");
                out.write("<input type = \"submit\" value = \"Keep Shopping\"/>\r\n</form>");

                // Button to Finalize Order - direct to final Order's receipt
                out.write("<form method = \"post\" action = \"/storeapp/placeOrder\">\r\n");
                out.write("<input type = \"submit\" value = \"Finalize Order\"/>\r\n</form>");

                // Button to Cancel and Exit Order - redirect to /Order, clears the session
                out.write("<form method = \"post\" action = \"/storeapp/placeOrderLoop\">\r\n");
                out.write("<input type = \"submit\" value = \"Cancel and Exit Order\"/>\r\n</form>");

                out.write("</body>");
            }
        }
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
    {
        System.out.println("Place Order -> POST; Finalize Order -> Clearing Session -> Redirects to /order");
        
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");
        out.write("<html><h2>Final Transaction</h2><body>");
        out.write(bl.displayFinalizeOrder(fullOrder, orderQtyList));

        out.write("<form method = \"post\" action = \"/storeapp/placeOrderLoop\">\r\n");
        out.write("<input type = \"submit\" value = \"Back to Order Menu\"/>\r\n</form>");

        out.write("</body>");
    }
    
}
