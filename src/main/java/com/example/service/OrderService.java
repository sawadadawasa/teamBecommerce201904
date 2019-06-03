package com.example.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Order;
import com.example.repository.OrderRepository;
import com.example.web.OrderForm;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findByUserId(int userId) {
		return orderRepository.findByUserId(userId);
	}
	public void saveFix(OrderForm orderForm) throws ParseException {
		Order order = new Order();
		BeanUtils.copyProperties(orderForm,order);
		
		//copy出来ないpaymentMethodをorderオブジェクトへ
		order.setPaymentMethod(Integer.parseInt(orderForm.getPaymentMethod()));
		
		//copyできないorderDateとdeliveryTimeをorderオブジェクトへ
		java.sql.Date orderDate = new java.sql.Date(new GregorianCalendar().getTime().getTime());
		order.setOrderDate(orderDate);
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy/mm/hh");
		java.util.Date formatDate = sdf.parse(orderForm.getDeliveryTime());
		order.setDeliveryTime(new Timestamp(formatDate.getTime()));
		
		orderRepository.saveFix(order); 
	}
}
