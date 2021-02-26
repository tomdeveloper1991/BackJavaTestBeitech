package com.beitech.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer>{

}
