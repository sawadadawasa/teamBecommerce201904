package com.example.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.OrderItem;
import com.example.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private HttpSession session;

	public void deleteId(int id) {
		orderItemRepository.deleteId(id);
	}

	public void addItem(int itemId, int quantity) {

		if(session.getAttribute("orderId") == null) {
			Integer orderId = orderItemRepository.saveAndReturnOrderId(itemId, quantity);
			session.setAttribute("orderId", orderId);
			
		} else {
			orderItemRepository.saveOnly(itemId, quantity);
		}

	}


}
