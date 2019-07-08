package com.example.web;


import java.sql.Timestamp;

public class OrderForm {
	private Integer id;//注文番号
	private Integer userId;
	private Integer totalPrice;//合計金額
	private String orderDate;//注文日　　　　　　//Orderの時にはDate型
	private String destinationName;//宛先氏名
	private String destinationEmail;//宛先Eメール
	private String destinationAddress;//宛先住所
	private String destinationTel;//宛先TEL
	private String deliveryTime;//配達日
	private Integer deliveryHour;//配達時間
	private String paymentMethod;//支払い方法
	private String postalCode;//郵便番号
	private Integer cardNumber;//クレジットカード番号
	private Integer limitOfMonth;//有効期限【月】
	private Integer limitOfYear;//有効期限【年】
	private String cardName;//カード名義人
	private Integer securityCode;//セキュリティコード 

	
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getLimitOfMonth() {
		return limitOfMonth;
	}
	public void setLimitOfMonth(Integer limitOfMonth) {
		this.limitOfMonth = limitOfMonth;
	}
	public Integer getLimitOfYear() {
		return limitOfYear;
	}
	public void setLimitOfYear(Integer limitOfYear) {
		this.limitOfYear = limitOfYear;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeliveryHour() {
		return deliveryHour;
	}
	public void setDeliveryHour(Integer deliveryHour) {
		this.deliveryHour = deliveryHour;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getDestinationEmail() {
		return destinationEmail;
	}
	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public String getDestinationTel() {
		return destinationTel;
	}
	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
