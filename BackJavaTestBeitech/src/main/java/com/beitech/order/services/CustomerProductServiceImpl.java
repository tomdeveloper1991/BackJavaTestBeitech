package com.beitech.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.beitech.order.dao.ICustomerProductDao;
import com.beitech.order.models.CustomerProduct;

@Service
@Configurable
public class CustomerProductServiceImpl implements CustomerProductService{
	
	@Autowired
	private ICustomerProductDao iCustomerProductDao;
	
	public List<CustomerProduct> findAll(){
		return iCustomerProductDao.findAll();
	}	
}
