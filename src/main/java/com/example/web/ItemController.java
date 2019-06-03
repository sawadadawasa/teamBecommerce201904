package com.example.web;


import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
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
	
	@RequestMapping(value = "show/{itemId}")
	public String show(@PathVariable("itemId") Integer id, Model model) {
		Item item = service.findOne(id);
		
		NumberFormat nfNum = NumberFormat.getNumberInstance(); 
		String viewPiece = nfNum.format(item.getPiece());
        
        
		model.addAttribute("item", item).addAttribute("viewPiece", viewPiece);
		return "item_detail";
	}
}
