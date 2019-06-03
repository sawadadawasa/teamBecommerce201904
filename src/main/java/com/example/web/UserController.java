package com.example.web;

import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.UserService;

@Controller
@RequestMapping(value="/tea")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	//フォームを初期化します。
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	//ログイン画面を表示します。
	@RequestMapping
	public String index() {
		return "login";
	}
	
	//ログイン処理を行います。
	@RequestMapping(value="/login")
	public String login(@Validated UserForm form,
			BindingResult result) {
		if(result.hasErrors()) {
			return index();
		}
	//入力値チェックを行います。	
		String email=form.getEmail();
		String password=form.getPassword();
		User user=userService.findOneByEmailAndPassword(email, password);
		if(user == null) {
			ObjectError error = new ObjectError("loginerror", "メールアドレスまたはパスワードが違います。");
            result.addError(error);
			return index();
		}
		session.setAttribute("user", user);
		
		System.out.println("mmmmmm");
		return "redirect:/js/login";
		
	}
	

}
