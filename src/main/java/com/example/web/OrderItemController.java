package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.ItemService;



@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	private ItemService itemService;
	@RequestMapping("/deleteItem")
	public String deleteItem(@RequestParam int id) {
		itemService.deleteItem(id);
		return "order";
	}
	

}
