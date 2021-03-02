package com.beitech.order.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "`customer_product`")
public class CustomerProduct {	
			
	@EmbeddedId
	private CustomerProductId customerProductId;

	public CustomerProductId getCustomerProductId() {
		return customerProductId;
	}

	public void setCustomerProductId(CustomerProductId customerProductId) {
		this.customerProductId = customerProductId;
	}
	
}
