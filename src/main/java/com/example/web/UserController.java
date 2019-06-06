package com.example.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.domain.User;
import com.example.service.UserService;

@Controller
@RequestMapping(value = "/user")
@Transactional
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
	// ユーザー登録画面
	@RequestMapping(value = "form")
	public String form() {
		return "newAccount";
	}
	// ログイン画面を表示します。
	@RequestMapping(value="viewDelete")
	public String viewDelete() {
		return "Unsubscribe";
	}

	// メンバー情報を登録します。
	@RequestMapping(value = "create")
	public String create(@Validated UserForm form, BindingResult result) {
		//ログイン画面にとび、成功したらアラートを出す。
		//Mapに値が入っていたらアラートをだす
		boolean str = false;
		
		if (result.hasErrors()) {
			return form();
		}

		List<User> users = userService.findAll();
		for (User user : users) {
			if ((user.getEmail()).equals(form.getEmail())) {
				ObjectError error = new ObjectError("addresserror", "このメールアドレスは既に登録されています。");
				result.addError(error);
			System.out.println(error);
				return form();
			}
		}

		// 確認用パスワードとパスワードが一致しなければエラー
		String password = form.getPassword();
		String passwordConfirm = form.getPasswordConfirm();
		if (!passwordConfirm.equals(password)) {
			ObjectError error = new ObjectError("loginerror", "パスワードと確認用パスワードが一致しません。");
			result.addError(error);
			return form();
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user=userService.save(user);
		
		str = true;
		session.setAttribute("registerMessage", str);
		return "redirect:/tea/";
	}
	
	// ユーザー情報を削除します。
	@RequestMapping(value = "delete")
	public String delete(@Validated LoginForm form, BindingResult result) {
		if(result.hasErrors()) {
			return viewDelete();
		}
		String email = form.getEmail();
		String password = form.getPassword();
		//エンコード用にインスタンス化
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
		boolean answer = false;

		if(enco.matches(password, userService.findPassword(email))) {
			answer = true;
		} 

		if(answer) {
			userService.deleteUserInfo(email);
			return "redirect:/logout/";
		} else {
			ObjectError error = new ObjectError("loginerror", "メールアドレスまたはパスワードが違います。");
			result.addError(error);
			return viewDelete();

		}
	}
}

