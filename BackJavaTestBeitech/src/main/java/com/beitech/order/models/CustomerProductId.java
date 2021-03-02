package com.beitech.order.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerProductId implements Serializable{

	private static final long serialVersionUID=1L;
	
	public CustomerProductId() {}
	
	public CustomerProductId(Integer customerId, Integer productId) {
		this.customerId=customerId;
		this.productId=productId;
	}
	
	@Column(name="`customer_id`")	
	private Integer customerId;
		
	@Column(name="`product_id`")	
	private Integer productId;		
	

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
