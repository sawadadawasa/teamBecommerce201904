package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	// メンバー情報を登録します。
	@RequestMapping(value = "create")
	public String create(@Validated UserForm form, BindingResult result) {

		if (result.hasErrors()) {
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
		return "redirect:/tea/";
	}
}
