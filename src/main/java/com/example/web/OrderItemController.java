package com.example.web;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.OrderItem;
import com.example.service.OrderItemService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	private OrderItemService orderItemService;
	
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	
	//商品の詳細を表示
	@RequestMapping("/")
	public String showItems(OrderItemForm form, Model model) {
		
		orderItemList	= orderItemService.findAll();
		
		model.addAttribute(orderItemList);
		
		return "order";
	}
	

	//商品をカートに追加、cart.jspに移動
	@RequestMapping("/addItem")
	public String addItem(OrderItemForm form) {
		
		

		return "order";
	}
	
	
	@RequestMapping("/deleteId")
	public String deleteItem(@RequestParam int id) {
		orderItemService.deleteId(id);
		return "order";
	}
	

	

}
