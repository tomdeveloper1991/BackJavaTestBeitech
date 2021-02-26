package com.beitech.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.beitech.order.dao.ICustomerDao;
import com.beitech.order.models.Customer;

@Service
@Configurable
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ICustomerDao iCustomerDao;
	
	public List<Customer> findAll(){
		return iCustomerDao.findAll();		
	}
}
