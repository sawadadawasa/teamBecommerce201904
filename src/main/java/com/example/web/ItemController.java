package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
	@Autowired
	private ItemService service;

	@RequestMapping(value="/")
	public String index(Model model) {
		service.itemFindAll(model);
		return "item_list";
	}
}
