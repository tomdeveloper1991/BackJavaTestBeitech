package com.beitech.order.dto;

import java.util.List;

import com.beitech.order.models.Product;

public class CreateOrderDto {
	
	private String creationDate;	
	private Integer customerId;
	private String deliveryAddress;	
	
	private List<Product> products;
	
	public CreateOrderDto() {
		super();
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
