package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.OrderItem;
import com.example.service.OrderItemService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	@Autowired
	OrderItemService service;
	
	//商品の詳細を表示
	@RequestMapping("/")
	public String shewItem(OrderItemForm form) {
		
		
		OrderItem orderItem = new OrderItem();
		
		//service.showItem(orderItem);
		
		return "cart";
	}
	
	//商品をカートに追加、cart.jspに移動
	@RequestMapping("/addItem")
	public String addItem(OrderItemForm form) {

		
		return "cart";
	}
	

}
