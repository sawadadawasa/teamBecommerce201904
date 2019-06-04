package com.example.web;

import javax.validation.constraints.NotBlank;

public class LoginForm {
	
	//メールアドレス
	@NotBlank(message = "値を入力してください。")
	private String email;
	
	//パスワード
	@NotBlank(message = "値を入力してください。")
	private String password;

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
	
}
