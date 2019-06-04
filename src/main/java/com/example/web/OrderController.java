package com.example.web;

import java.util.Date;
import java.util.LinkedHashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
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
import com.example.domain.OrderItem;
import com.example.domain.User;
import com.example.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	private final JavaMailSender javaMailSender;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private HttpSession session;

	@Autowired
	OrderController(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	@ModelAttribute
	public OrderForm setUpForm() {
		return new OrderForm();
	}
	//注文履歴を表示(注文した後の話)
	@RequestMapping("/searchOrderHistory")
	public String searchOrHistory(Model model) {
		User user = (User)session.getAttribute("user");
		if(user==null) return "redirect:/tea/";
		List<Order> orderHistoryList = orderService.findByUserId(user.getId());
		model.addAttribute("orderHistoryList",orderHistoryList);
		return "orderHistory";
	}
	//注文を確定する.Orders DB更新
	@RequestMapping("/fix")
	public String order(OrderForm orderForm,RedirectAttributes redirectAttributes) throws ParseException {
		orderService.saveFix(orderForm);
		redirectAttributes.addFlashAttribute("destinationEmail",orderForm.getDestinationEmail());
		System.out.println("debug");
		return "redirect:/order/mail/send";
	}
	//order.jspへ遷移
	@RequestMapping("/view")
	public String view(Model model) {
		User user = (User)session.getAttribute("user");
		if(user==null) return "redirect:/tea/";
		
		
		Map<Integer,Integer> hourList = new LinkedHashMap<>();
		for(int i =10;i <= 18;i++) {
			hourList.put(i,i);
		}
		Map<Integer,String> paymentMethodList = new LinkedHashMap<>();
		paymentMethodList.put(0,"代金引換");
		paymentMethodList.put(1,"クレジットカード");
		
		model.addAttribute("hourList",hourList);
		model.addAttribute("paymentMethodList",paymentMethodList);
		
		return "order";	
	}
	

	
	@RequestMapping(value = "/mail/send", method = {RequestMethod.GET} )
	public String send(@ModelAttribute("destinationEmail")String destinationEmail) {
		
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();

	    mailMessage.setTo("destinationEmail");
	    mailMessage.setReplyTo("test.bayashi.dev@gmail.com");
	    mailMessage.setFrom(destinationEmail);
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
	
	//注文が配達予定より3日以上前であることを確認する(削除ボタンを出力する)
	@RequestMapping("/booleanDeleteOrNot")
	public String booleanDeleteOrNot(@ModelAttribute("orderId")Integer orderId,Model model) {
		Integer deleteOrNot = orderService.booleanDeleteOrNot(orderId);
		String deleteOrNotMessage;
		if(deleteOrNot !=null) deleteOrNotMessage = "削除する";//配達予定より3日以上前の時点であればdeleteOrNotMessageに削除ボタンを出力
		else deleteOrNotMessage = "null" ;
		model.addAttribute("deleteOrNotMessage",deleteOrNotMessage);
		return "historyDetail";
	}
	
	
	
}
