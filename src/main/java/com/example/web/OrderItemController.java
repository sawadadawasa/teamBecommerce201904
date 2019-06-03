package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.ItemService;
import com.example.service.OrderItemService;



@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	private OrderItemService orderItemService;
	@RequestMapping("/deleteId")
	public String deleteItem(@RequestParam int id) {
		orderItemService.deleteId(id);
		return "order";
	}
	
	

}
