package com.beitech.order.services;

import java.util.List;

import com.beitech.order.models.CustomerProduct;

public interface CustomerProductService {

	public List<CustomerProduct> findAll();
	
	public List<CustomerProduct> findByIdCustomer(Integer idCustomer);
		
}
