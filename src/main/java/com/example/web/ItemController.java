package com.example.web;


import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
	@Autowired
	private ItemService service;
	
	//商品一覧を表示
	@RequestMapping(value="/")
	public String index(Model model) {
		service.itemFindAll(model);
		return "item_list";
	}
	
	//商品詳細画面に遷移
	@RequestMapping(value = "show/{itemId}")
	public String show(@PathVariable("itemId") Integer id, Model model) {
		service.findOne(model,id);
		return "item_detail";
	}
	
	//商品詳細画面に遷移
	@RequestMapping(value = "/serch")
	public String serch(@RequestParam String code, Model model) {
		service.itemFindMatch(model, code);
		return "item_list";
	}
	
}
