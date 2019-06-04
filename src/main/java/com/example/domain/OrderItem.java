package com.example.domain;
//消していいやつ(真鍋)
public class OrderItem {

	private int id; //ID
	private String name; //名前
	private int price; //値段
	private String imagePATH; //画像パス
	private String piece; //パック数
	private int quantity; //個数
	private int subTotalPrice; //小計
	
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
	public int getSubTotalPrice() {
		return subTotalPrice;
	}
	public void setSubTotalPrice(int subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
