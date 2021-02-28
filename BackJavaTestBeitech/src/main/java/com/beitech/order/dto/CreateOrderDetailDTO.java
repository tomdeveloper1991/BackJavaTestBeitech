package com.beitech.order.dto;

public class CreateOrderDetailDTO {
	private Integer productId;
	private String productDescription;
	private Integer quantity;
	
	public CreateOrderDetailDTO(Integer productId, String productDescription, Integer quantity) {
		this.productId=productId;
		this.productDescription=productDescription;
		this.quantity=quantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
