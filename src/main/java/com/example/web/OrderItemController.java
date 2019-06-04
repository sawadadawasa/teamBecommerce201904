package com.example.web;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.OrderItem;
import com.example.service.OrderItemService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;	
	
	@Autowired
	private HttpSession session;
	
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	
	//商品の詳細を表示
	@RequestMapping
	public String showItems(OrderItemForm form, Model model) {
		
		orderItemService.addItem(6, 6);
		
		System.out.println("OrdeItem");
		
		Integer orderId = (Integer)session.getAttribute("orderId");
		
		if(orderId != null) {
		orderItemList	= orderItemService.findAll(orderId);
		
		}
		
		model.addAttribute(orderItemList);
		
		return "cart_list";
	}
	
	//商品をカートに追加、cart_list.jspに移動
	@RequestMapping("/addItem")
	public String addItem(OrderItemForm form) {
		
		System.out.println("additem");
		
		Integer itemId = form.getItemId();
		Integer quantity = form.getQuantity();
		
		orderItemService.addItem(itemId, quantity);
		
		return "redirect:/orderItem/";
	}
	//orderHistoryからの遷移
	@RequestMapping("/showHistoryDetail")
	public String showHistoryDetail(int orderId) {
		orderItemService.findByOrderId(orderId);
		return "historyDetail";
	}
	
	@RequestMapping("/deleteId")
	public String deleteItem(@RequestParam int id) {
		orderItemService.deleteId(id);
		return "redirect:/orderItem/";
	}
	

	

}
