package com.example.domain;
//消していいやつ(真鍋)
public class OrderItem {

	private String name; //名前
	private int price; 
	private String imagePATH;
	private String piece;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImagePATH() {
		return imagePATH;
	}
	public void setImagePATH(String imagePATH) {
		this.imagePATH = imagePATH;
	}
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
