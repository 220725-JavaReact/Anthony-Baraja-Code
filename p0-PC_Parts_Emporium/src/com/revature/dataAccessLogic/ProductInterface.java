package com.revature.dataAccessLogic;

import java.util.List;

public interface ProductInterface<ProductPC> {
	
	List<ProductPC> getAllByStoreId(int store_id);

}
