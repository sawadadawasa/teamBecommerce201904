package com.example.web;

import java.util.LinkedHashMap;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.domain.Order;
import com.example.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	private final JavaMailSender javaMailSender;
	
	@Autowired
	private OrderService orderService;
	

	@Autowired
	OrderController(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	@ModelAttribute
	public OrderForm setUpForm() {
		return new OrderForm();
	}
	@RequestMapping("/searchOrderHistory")
	public String searchOrHistory(Model model) {
		int userId =1;//エラーが起こらないための一時的ダミー
		List<Order> orderHistoryList = orderService.findByUserId(userId);
		model.addAttribute("orderHistoryList",orderHistoryList);
		return "orderHistory";
	}
	
	@RequestMapping("/fix")
	public String order(OrderForm orderForm,RedirectAttributes redirectAttributes) throws ParseException {
		orderService.saveFix(orderForm);
		redirectAttributes.addFlashAttribute("destinationEmail",orderForm.getDestinationEmail());
		System.out.println("debug");
		return "redirect:/order/mail/send";
	}

	@RequestMapping("/view")
	public String view(Model model) {
		Map<Integer,Integer> hourList = new LinkedHashMap<>();
		for(int i =10;i <= 18;i++) {
			hourList.put(i,i);
		}
		model.addAttribute("hourList",hourList);
		return "order";	
	}
	

	
	@RequestMapping(value = "/mail/send", method = {RequestMethod.GET} )
	public String send(@ModelAttribute("destinationEmail")String destinationEmail) {
		
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();

	    mailMessage.setTo("akt20.takutomato@gmail.com");
	    mailMessage.setReplyTo("test.bayashi.dev@gmail.com");
	    mailMessage.setSubject("テストメール");
	    mailMessage.setText("テストメールです、\nここから次の行\nおわりです\n");

	    javaMailSender.send(mailMessage);

		return "orderCompletion";
	}
	//注文削除した後の画面へ移行
	@RequestMapping(value="/deleteOrder")
	public String deleteOrder(int orderId) {
		orderService.deleteOrder(orderId);
		return "deleteOrder";
	}
	
	//注文が30分以内であることを確認する(削除ボタンを出力する)
	@RequestMapping("/booleanDeleteOrNot")
	public String booleanDeleteOrNot(@ModelAttribute("orderId")Integer orderId,Model model) {
		Integer deleteOrNot = orderService.booleanDeleteOrNot(orderId);
		String deleteOrNotMessage;
		if(deleteOrNot !=null) deleteOrNotMessage = null;//30分以内でした
		else deleteOrNotMessage = "削除する" ;
		model.addAttribute("deleteOrNotMessage",deleteOrNotMessage);
		System.out.println(orderId);
		return "historyDetail";
	}
}
