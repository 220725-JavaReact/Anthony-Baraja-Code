package com.revature.businessLogic;

import com.revature.dataAccessLogic.CustomerDBDAOLogic;
import com.revature.dataAccessLogic.LineItemsDaoLogic;
import com.revature.dataAccessLogic.ProductDBDAO;
import com.revature.dataAccessLogic.StoreFrontDaoLogic;
import com.revature.models.Customer;
import com.revature.models.LineItems;
import com.revature.models.Product;
import com.revature.models.StoreFront;
import com.revature.util.AsciiUI;

public class BusinessLogic {

    private static CustomerDBDAOLogic customerDao = new CustomerDBDAOLogic();
    private static StoreFrontDaoLogic storeFrontDao = new StoreFrontDaoLogic();
    private static ProductDBDAO productDao = new ProductDBDAO();
	private static LineItemsDaoLogic lineItemsDao = new LineItemsDaoLogic();

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
    
}
