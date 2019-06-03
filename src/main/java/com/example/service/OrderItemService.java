package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.OrderItem;
import com.example.repository.OrderItemRepository;

@Service
public class OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public void addItem(int itemId) {
		OrderItem orederItem = new OrderItem();
		orederItem = orderItemRepository.addItem(itemId);
		
	}
	

}
