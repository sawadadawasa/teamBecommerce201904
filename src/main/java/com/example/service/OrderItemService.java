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
		orderItemRepository.saveOnly(itemId, quantity);
		
	} else if(session.getAttribute("orderId") == null) {
		
	Integer orderId = orderItemRepository.saveAndReturnOrderId(itemId, quantity);
	
			session.setAttribute("orderId", orderId);
		
	}
}

public List<OrderItem> findByOrderId(int orderId) {
	return orderItemRepository.findAllHistoryDetail(orderId);
}

//ショッピングカートの中身を消すメソッド
public void deleteId(int id) {
	orderItemRepository.deleteId(id);
}

//合計金額を計算するメソッド
public Integer calcTotalPrice(List<OrderItem> orderItemList) {
	
	Integer totalPrice = 0;
	
	for(OrderItem orderItem : orderItemList ) {
		totalPrice += orderItem.getSubTotalPrice();
		
	}
	
	return totalPrice;
	
}


}
