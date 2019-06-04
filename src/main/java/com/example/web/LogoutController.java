package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.domain.User;

//ログアウト機能
@Controller
@RequestMapping(value="/logout")
@SessionAttributes("user")
public class LogoutController {

	@RequestMapping(value="/")
	public String index() {
		return "home";
	}
	
	@RequestMapping(value = "/sessionInvalidate")
	public String logout(User user
			, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}

}
