package com.example.web;

public class OrderItemForm {
	
	private String id;
	private String itemId;
	
	public Integer getId() {
		return Integer.parseInt(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getItemId() {
		return Integer.parseInt(itemId);
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
