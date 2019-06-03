package com.example.web;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Order;
import com.example.demo.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@ModelAttribute
	public OrderForm setUpForm() {
		return new OrderForm();
	}
	@RequestMapping("/searchOrderHistory")
	public String searchOrHistory(Model model) {
		int userId =1;//エラーが起こらないための一時的ダミー
		List<Order> orderHistoryList = orderService.findByUserId(userId);
		model.addAttribute("orderHistoryList",orderHistoryList);
		return "orderHistory";
	}
	
	@RequestMapping("/fix")
	public String order(OrderForm orderForm) throws ParseException {
		orderService.saveFix(orderForm);
		return "orderCompletion";
	}

	@RequestMapping("/view")//後で澤田君の作ったのと合わせた後に消す
	public String view() {
		return "order";
		
	}
	
	
}
