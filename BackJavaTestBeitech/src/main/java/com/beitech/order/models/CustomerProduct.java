package com.beitech.order.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "`customer_product`")
public class CustomerProduct implements Serializable{
	
	private static final long serialVersionUID=1L;	
	
	@Id
	@Column(name="`customer_id`")	
	private Integer customerId;
		
	@ManyToOne
	@JoinColumn(name = "`product_id`", referencedColumnName = "`product_id`", nullable=false)
	private Product product;
	
		
	public CustomerProduct() {
		super();
	}
	
	public CustomerProduct(Integer customerId, Product product) {
		super();
		this.customerId=customerId;
		this.product=product;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Product getProductId() {
		return product;
	}

	public void setProductId(Product product) {
		this.product = product;
	}

		
}
