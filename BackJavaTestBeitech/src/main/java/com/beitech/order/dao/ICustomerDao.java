package com.beitech.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>{
	
}
