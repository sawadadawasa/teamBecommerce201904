package com.example.domain;
//消していいやつ(真鍋)
public class OrderItem {
	
	private int id; //
	private int itemId; //商品ID
//	private int orderId;  
	private int quantity;
	
	public OrderItem(int id, int itemId, int quantity) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public OrderItem() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
//	public int getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
