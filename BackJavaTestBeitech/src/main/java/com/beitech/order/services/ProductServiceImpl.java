package com.beitech.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.beitech.order.dao.IProductDao;
import com.beitech.order.models.Product;

@Service
@Configurable
public class ProductServiceImpl implements ProductService{

	@Autowired
	private IProductDao iProductDao;
	
	public List<Product> findAll(){
		return iProductDao.findAll();		
	}
}
