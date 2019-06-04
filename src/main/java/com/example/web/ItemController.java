package com.example.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
	@Autowired
	private ItemService service;
	
	@ModelAttribute
	public OrderItemForm setUpForm() {
		return new OrderItemForm();
	}
	
	//商品一覧を表示
	@RequestMapping
	public String listAll(Model model) {
	
		service.itemFindAll(model);
		service.itemOriginList(model);
		service.itemPieceList(model);
		return "item_list";
	}
	
	//商品詳細画面に遷移
	@RequestMapping(value = "/serch")
	public String serch(@RequestParam String code, @RequestParam String origin, @RequestParam String piece, Model model) {
		service.itemOriginList(model);
		service.itemPieceList(model);
		service.itemFindMatch(code, origin, piece, model);
		return "item_list";
	}
	
	//商品詳細画面に遷移
	@RequestMapping(value = "/show/{itemId}")
	public String show(@PathVariable("itemId") Integer id, Model model) {
		service.findOne(model,id);
		return "item_detail";
	}
	
}
