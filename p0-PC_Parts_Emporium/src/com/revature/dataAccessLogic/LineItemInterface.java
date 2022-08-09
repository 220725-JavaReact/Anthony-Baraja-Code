package com.revature.dataAccessLogic;

import com.revature.models.LineItems;

public interface LineItemInterface {
	
	LineItems getByProdId(int product_id);

}
