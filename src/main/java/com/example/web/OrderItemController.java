package com.example.web;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.servlet.http.HttpSession;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ModelAttribute
	public OrderItemForm setUpForm() {
		return new OrderItemForm();
	}
	
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	 
	//商品の詳細を表示
	@RequestMapping
	public String showItems(OrderItemForm form, Model model) {
		
		Integer orderId = (Integer)session.getAttribute("orderId");
		
		if(orderId != null) {
		orderItemList	= orderItemService.findAll(orderId);
		
		}
		
		//合計金額
		Integer totalPrice = orderItemService.calcTotalPrice(orderItemList);
		
		//消費税
		Integer taxOfTotalPrice = (int)(totalPrice*0.08);
		
		NumberFormat nfNum = NumberFormat.getNumberInstance();
		
		String viewTotalPrice = nfNum.format(totalPrice);
		String viewTaxOfTotalPrice = nfNum.format(taxOfTotalPrice);
		
		model.addAttribute("orderItemList", orderItemList)
		.addAttribute("viewTotalPrice", viewTotalPrice).
		addAttribute("viewTaxOfTotalPrice", viewTaxOfTotalPrice);
				
		return "cart_list";
	}
	
	//商品をカートに追加、cart_list.jspに移動
	@RequestMapping("/addItem")
	public String addItem(OrderItemForm form) {
				
		Integer itemId = form.getItemId();
		Integer quantity = form.getQuantity();
		
		orderItemService.addItem(itemId, quantity);
		
		return "redirect:/orderItem";
	}
	//orderHistoryからの遷移
	@RequestMapping("/showHistoryDetail")
	public String showHistoryDetail(@RequestParam int orderId,RedirectAttributes redirectAttributes) {
		List<OrderItem> orderItemList = orderItemService.findByOrderId(orderId);
		redirectAttributes.addFlashAttribute("orderItemList",orderItemList);
		redirectAttributes.addFlashAttribute("orderId",orderId);
		return "redirect:/order/booleanDeleteOrNot";
	}
	
	@RequestMapping("/deleteId/{Id}")
	public String deleteItem(@PathVariable("Id") Integer id) {

		orderItemService.deleteId(id);
		
		return "redirect:/orderItem";
	}

	@RequestMapping("/cart")
	public String cart() {
		return "redirect:/orderItem";
	}

	

}
