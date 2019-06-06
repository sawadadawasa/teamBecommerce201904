package com.example.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.domain.User;

/**
 * ログアウト関連処理を行うコントローラー.<br>
 * ※ログイン認証フィルターが実施するため使用しなくなりました
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	/**
	 * セッション情報に含まれるMemberオブジェクトをクリアします.
	 * @param member Sessionに入っているメンバー情報
	 * @param sessionStatus　セッションステータス
	 * @return　ログイン画面
	 */
	@RequestMapping(value = "sessionInvalidate")
	public String sessionInvalidate() {
		session = request.getSession();
		session.invalidate();
		session = request.getSession(true);
		
		return "redirect:/tea/";
	}

}
