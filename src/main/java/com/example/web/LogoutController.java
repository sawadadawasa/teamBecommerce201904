package com.example.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//home.jsp を表示
	@RequestMapping(value="/")
	public String index() {
		return "home";
	}
	
	@RequestMapping(value = "/sessionInvalidate")
	public String logout(User user
			, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
	
		return "redirect:/logout/";
	}

}
