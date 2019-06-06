package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/godtea")
public class CommonController {


	// ホーム画面を表示します。
	@RequestMapping(value="/")
	public String index() {
		return "home";
	}
}
