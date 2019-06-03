package com.example.web;

import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		System.out.println("mmmmmm");
		if(result.hasErrors()) {
			return index();
		}
	//入力値チェックを行います。	
		String email=form.getEmail();
		String password=form.getPassword();
		User user=userService.findOneByEmailAndPassword(email, password);
		System.out.println("kkkkkk");
		
		session.setAttribute("user", user);
		
		System.out.println("nnnnnn");
		return "redirect:/js/login";
		
	}
	
	//メンバー登録画面
	@RequestMapping(value = "/form")
	public String form() {
		System.out.println("aaa");
		return "newAccount";
	}
	
	//メンバー情報を登録します。
	@RequestMapping(value = "create")
	public String create(@Validated UserForm form, 
			BindingResult result,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return form();
		}
		List<User> users = userService.findAll();
		for (User user : users) {
			if ((user.getEmail()).equals(form.getEmail())) {
				ObjectError error = new ObjectError("addresserror", "このメールアドレスは既に登録されています。");
				result.addError(error);
				return form();
			}
		}
		
		//確認用パスワードとパスワードが一致しなければエラー
		String password=form.getPassword();
		String passwordConfirm=form.getPasswordConfirm();
		if(!passwordConfirm.equals(password)) {
			ObjectError error=new ObjectError("loginerror","パスワードと確認用パスワードが一致しません。" );
			 result.addError(error);
			 return form();
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		userService.save(user);
		return "redirect:/";
	}
	

}
