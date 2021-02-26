package com.beitech.order.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer_product")
public class CustomerProduct implements Serializable{
	
	private static final long serialVersionUID=1L;	
	
	@Id
	@Column(name="customer_id")	
	private Integer customerId;	
		
	@Column(name="product_id")	
	private Integer productId;
	
		
	public CustomerProduct() {
		super();
	}		
	
	public CustomerProduct(Integer customer, Integer product) {
		super();
		this.customerId=customer;
		this.productId=product;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

		
}
