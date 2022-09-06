package com.revature.businessLogic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


import com.revature.dataAccessLogic.CustomerDBDAOLogic;
import com.revature.dataAccessLogic.LineItemsDaoLogic;
import com.revature.dataAccessLogic.OrderDaoLogic;
import com.revature.dataAccessLogic.OrderLinkDaoLogic;
import com.revature.dataAccessLogic.ProductDBDAO;
import com.revature.dataAccessLogic.StoreFrontDaoLogic;
import com.revature.models.Customer;
import com.revature.models.LineItems;
import com.revature.models.Order;
import com.revature.models.OrderLink;
import com.revature.models.Product;
import com.revature.models.StoreFront;
import com.revature.util.AsciiUI;

public class BusinessLogic {

    private static CustomerDBDAOLogic customerDao = new CustomerDBDAOLogic();
    private static StoreFrontDaoLogic storeFrontDao = new StoreFrontDaoLogic();
    private static ProductDBDAO productDao = new ProductDBDAO();
	private static LineItemsDaoLogic lineItemsDao = new LineItemsDaoLogic();
    private static OrderLinkDaoLogic orderLinkDao = new OrderLinkDaoLogic();
    private static OrderDaoLogic orderDao = new OrderDaoLogic();

    public String displayAllCustomers(){
        String result = "<div id=\"customers\">";

        for(Customer customer: customerDao.getAll()){
            result = result + "<p>" + customer.getInfo() + "</p>";
		}
        
        return result + "</div>";
    }

    public String listAllCustomerSelections(){
        String result = "<div id=\"customers\"><ol>";

        for(Customer customer: customerDao.getAll()){
            result = result + "<li>" + customer.getName() + "</li>";
		}
        
        return result + "</ol></div>";
    }

    public String dropDownAllCustomerSelections(){
        String result = "<div id=\"customers\"><select name = \"customer_id\">";

        for(Customer customer: customerDao.getAll()){
            result = result + "<option value = \"" + customer.getId() + "\">" + customer.getName() + "</option>";
            
		}
        
        return result + "</select></div>";
    }

    public String displaySearchedCustomer(String name){
        String result = "<div id=\"customer\">";

        Customer fetchedCustomer = customerDao.getCustomerByName(name);
        if(fetchedCustomer == null) {
			//System.out.println("No Customer was found.");
            result = result + "<p>" + name + " customer not found</p>";
		} else {
			result = result + "<p>" + fetchedCustomer.getInfo() + "</p>";
		}

        
        return result + "</div>";
    }

    public void addCustomer(String name, String address, String email, String phone) {
		
		// Generate a placeholder ID for new customer
		int newId = 0;
		Customer newCustomer= new Customer(newId, name, address, email, phone);
		customerDao.save(newCustomer);
	}

    public String listAllStoreFrontSelections(){
        String result = "<div id=\"customers\"><ol>";

        for(StoreFront store: storeFrontDao.getAll()){
            result = result + "<li>" + store.getName() + "</li>";
		}
        
        return result + "</ol></div>";
    }

    public String dropDownAllStoreFrontSelections(){
        String result = "<div id=\"stores\"><select name = \"store_id\">";

        for(StoreFront store: storeFrontDao.getAll()){
            result = result + "<option value = \"" + store.getId() + "\">" + store.getName() + "</option>";
            
		}
        
        return result + "</select></div>";
    }

    public String listAllProductSelectionsByStoreID(int storeId){
        String result = "<div id=\"products_selections\"><ol>";
        String newProdType = "";
		String currentType = "";

        for(Product product: productDao.getAllByStoreId(storeId)){
            LineItems lineItem = lineItemsDao.getByProdId(product.getId());

            currentType = product.getCategory();
            if(!currentType.equals(newProdType)){
                result = result + AsciiUI.printProductType(currentType);
                newProdType = currentType;
            }
            
            String strStock = "  -  Stock: ";
            if(lineItem.getQuantity() == 0){
                strStock = strStock + "OUT OF STOCK!";
            } else {
                strStock = strStock + lineItem.getQuantity() + " left";
            }

            result = result + "<li>" + product.getName() + "  -  Price: $" + product.getPrice() + strStock + "</li>";
		}
        
        return result + "</ol></div>";
    }

    public String dropDownAllProductSelectionsByStoreID(int storeId){
        String result = "<div id=\"products_dropdown\"><select name = \"prod_id\">";

        int count = 1;
        for(Product product: productDao.getAllByStoreId(storeId)){
            result = result + "<option value = \"" + product.getId() + "\">" + count + " - " + product.getName() + "</option>";
            count++;
		}
        
        return result + "</select></div>";
    }

    public Double setOrderPrice(int prodId, int qtyNum){
        Double result = 0.0;
        Product product = productDao.get(prodId);
        result = result + product.getPrice() * qtyNum;
        
        return result;
    }

    public int getNewOrderLinkId(){
        int orderLinkId = orderLinkDao.getAll().size() + 1;
        return orderLinkId;
    }

    public boolean checkUserQtyNotOverLineItemQtyLimit(int lineItemId, int qty) {
		LineItems currentLineItems = lineItemsDao.get(lineItemId);
		return qty < currentLineItems.getQuantity();
	}

    public String displayOrderDetails(List<Order> currentOrdersList, ArrayList<Integer> orderQtyList)
    {
        String result = "<div id=\"order_details\">";
        
        result = result + "<h1>***** ORDER #" + currentOrdersList.get(0).getOrder_link() + " *****</h1>";
        
        int storeID = currentOrdersList.get(0).getStore_id();
        StoreFront storeFront = storeFrontDao.get(storeID);
        result = result + "<h2>STORE: " + storeFront.getName() + "   ||   ADDRESS: " + storeFront.getAddress() + "</h2>";

        Double subTotal = 0.0;

        for(int i = 0; i < currentOrdersList.size(); i++) {
            result = result + "<h1>----------------------------------------------------------</h1>";
			
            Order order = currentOrdersList.get(i);
			LineItems currentLineItem = lineItemsDao.get(order.getLineItem_id());
			Product currentProduct = productDao.get(currentLineItem.getProductId());
			int userQuantity = orderQtyList.get(i);
			
            Double currentLinePrice = currentProduct.getPrice()*userQuantity;
			subTotal += currentLinePrice;
			
            //System.out.println("PC Component: " + currentProduct.getCategory() + "  ||  " + currentProduct.getName() + "  ||  qty:" + userQuantity + "  ||  Price = $" + currentLinePrice);
            result = result + "<h2>PC Component: " + currentProduct.getCategory() + "  ||  " + currentProduct.getName() + "  ||  qty:" + userQuantity + "  ||  Price = $" + currentLinePrice + "</h2>";
		}

        //System.out.println("\nSubtotal = $" + subTotal);
        result = result + "<h2>Subtotal = $" + subTotal + "</h2>";
		result = result + "<h1>==========================================================</h1>";

        return result;
    }

    public String displayFinalizeOrder(List<Order> currentOrdersList, ArrayList<Integer> orderQtyList)
    {
        String result = "<div id=\"order_details\">";

        int currentOrderLinkId = currentOrdersList.get(0).getOrder_link();
        
        result = result + "<h1>***** FINAL ORDER #" + currentOrderLinkId + " *****</h1>";

		Double grandTotal = 0.0;
		Double subTotal = 0.0;
		Double salesTax = 0.0;
		
		// Create order link record
		OrderLink currentOrderLink = new OrderLink(1, subTotal);
		orderLinkDao.save(currentOrderLink);
		currentOrderLink = orderLinkDao.get(currentOrderLinkId);
		
		for(int i = 0; i < currentOrdersList.size(); i++) {
			Order order = currentOrdersList.get(i);
			
			order.setOrder_link(currentOrderLinkId);
			orderDao.save(order);
			
			subTotal += order.getTotalPrice();
			salesTax = getLocationSaleTax(order);
			
			// Update line item product stock
			LineItems currentLineItem = lineItemsDao.get(order.getLineItem_id());
			int newQtyAmount = currentLineItem.getQuantity() - orderQtyList.get(i); 
			currentLineItem.setQuantity(newQtyAmount);
			lineItemsDao.update(currentLineItem);
		}
		
		// Calculate Grand Total
		//System.out.println("Subtotal = $" + subTotal);
        result = result + "<h3>Subtotal = $" + subTotal + "</h3>";
		double salesTaxValue = salesTax / 100 * subTotal;
		double salesTaxValueFrmt = getValueFormattedTwoDecimals(salesTaxValue);
		//System.out.println("Sales Tax = $" + salesTaxValueFrmt);
        result = result + "<h3>Sales Tax = $" + salesTaxValueFrmt + "</h3>";
		grandTotal = salesTaxValueFrmt + subTotal;
		double grandTotalFrmt = getValueFormattedTwoDecimals(grandTotal);
		//System.out.println("Grand Total = $" + grandTotalFrmt);
        result = result + "<h3>Grand Total = $" + grandTotalFrmt + "</h3>";
		
		// Update order link record with calculated Grand Total
		currentOrderLink.setSubTotal(grandTotalFrmt);
		orderLinkDao.update(currentOrderLink);		
		
		//System.out.println("Order record to database submitted successfully!");
        result = result + "<h2>Order record to database submitted successfully!</h2>";
        
        return result;
	}

    /**
	 * Returns the sales tax rate according to location from given order.
	 * @param order
	 * @return Double Sales Tax Rate
	 */
	public Double getLocationSaleTax(Order order) {
		Double salesTax = 0.0;
		StoreFront currentStore = storeFrontDao.get(order.getStore_id());
		String currentAddress = currentStore.getAddress();
		
		if (currentAddress.contains("San Fernando")) {
			salesTax = 10.250;
		}else if (currentAddress.contains("Los Angeles")) {
			salesTax = 9.500;
		}else if (currentAddress.contains("San Diego")) {
			salesTax = 7.750;
		}else if (currentAddress.contains("Venice")) {
			salesTax = 9.500;
		}
		
		return salesTax;
	}

    /**
	 * Returns double formatted by 2 decimal places.
	 * @param value
	 * @return Double
	 */
	public Double getValueFormattedTwoDecimals(Double value) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		String strResult = formatter.format(value);
		return Double.parseDouble(strResult);
	}
    
}
