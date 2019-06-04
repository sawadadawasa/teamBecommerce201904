package com.example.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class UserForm {
	
	private Integer id;
	
	//名前
	@NotBlank(message = "名前は必須です。")
	@Size(min=1,max=50, message="名前は1文字以上50文字以内で記入してください。(全角半角可)")
	private String name;
	
	//メールアドレス
	@NotBlank(message = "メールアドレスは必須です。")
	@Email(message = "Eメール形式が不正です。")
	private String email;
	
	//パスワード
	@NotBlank(message = "パスワードは必須です。")
	@Size(min=6,max=12, message="パスワードは半角英数字で6文字以上12文字以内で記入してください。")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "パスワードは半角英数字で記入してください。")
	private String password;
	
	//住所
	@NotBlank(message = "住所は必須です。")
	private String address;
	
	
	private String postalCode;
	
	//電話番号
	@NotBlank(message = "電話番号は必須です。")
	@Size(min=10,max=11, message = "電話番号は10~11桁の半角数字の「-」無しで記入してください。")
	@Pattern(regexp = "[0-9]*", message = "電話番号は半角数字で記入してください。")
	private String telephone;
	
	
	private String pageparam;
	
	//確認用パスワード
	@NotBlank(message = "確認用パスワードは必須です。")
	private String passwordConfirm;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPageparam() {
		return pageparam;
	}
	public void setPageparam(String pageparam) {
		this.pageparam = pageparam;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
