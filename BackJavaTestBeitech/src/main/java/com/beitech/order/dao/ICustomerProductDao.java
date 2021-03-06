package com.beitech.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.CustomerProduct;

@Repository
public interface ICustomerProductDao extends JpaRepository<CustomerProduct, Integer>{
	
	public List<CustomerProduct> findByCustomerProductIdCustomerId(Integer customerId); 
	
}
