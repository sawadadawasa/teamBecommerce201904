package com.example.service;

import java.util.List;
import java.util.ArrayList;

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

	List<OrderItem> orderItemList = new ArrayList<OrderItem>();

	public List<OrderItem> findAll(Integer orderId){

		return orderItemRepository.findAll(orderId);

	}

	public void addItem(int itemId, int quantity) {

	 if (session.getAttribute("orderId") != null){
		 System.out.println("orderIdはnullじゃない");
		orderItemRepository.saveOnly(itemId, quantity);
		
	} else if(session.getAttribute("orderId") == null) {
		System.out.println("orderIdはnull");
		
	Integer orderId = orderItemRepository.saveAndReturnOrderId(itemId, quantity);
	
			session.setAttribute("orderId", orderId);
		
	}
}

public List<OrderItem> findByOrderId(int orderId) {
	return orderItemRepository.findAllHistoryDetail(orderId);
}

public void deleteId(int id) {
	orderItemRepository.deleteId(id);
}


}
