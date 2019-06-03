package com.example.repository;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.OrderItem;
import com.example.service.OrderItemService;

@Repository
@Transactional
public class OrderItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate2;
	
	@Autowired
	private HttpSession session;
	
	List<OrderItem> orderItemList = new ArrayList<OrderItem>();

		
	private static final RowMapper<OrderItem> ORDERITEM_ROW_MAPPER = (rs, i) -> {
		OrderItem orderItem = new OrderItem();
		int id = rs.getInt("id");
		int itemId = rs.getInt("item_id");
		int orderId = rs.getInt("order_id");
		int quantity = rs.getInt("quantity");
		orderItem.setId(id);
		orderItem.setItemId(itemId);
		orderItem.setOrderId(orderId);
		orderItem.setQuantity(quantity);
		return orderItem;
	};
	
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("order_items");
	}
	
	public List<OrderItem> findAll(){
		
		String sql = "SELECT   FROM order_items INNER JOIN items ON order_items.item_id = items.id";
		
		orderItemList = jdbcTemplate.query(sql, ORDERITEM_ROW_MAPPER);
		
		return orderItemList;
		
	}

	
	public Integer saveAndReturnOrderId(int itemId,  int quantity) {
		
		String selectSql = "SELECT max(id)+1 FROM order";
		
		Integer orderId = jdbcTemplate2.queryForObject(selectSql,  Integer.class);
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId",itemId).addValue("quantity", quantity).addValue("orderId", orderId);
		
		String insertSql = "INSERT INTO order_items (item_id, order_id quantity)VALUES (:itemId, :orderId, :quantity)";
		
		jdbcTemplate.update(insertSql, param);
		
		return orderId;
		
	}
	
	public void saveOnly (int itemId, int quantity) {
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId",itemId).addValue("quantity", quantity).addValue("orderId", session.getAttribute("orderId"));
		
		String insertSql = "INSERT INTO order_items (item_id, order_id quantity)VALUES (:itemId, :orderId, :quantity)";
		
		jdbcTemplate.update(insertSql, param);
		
	}
	
	public void deleteId(int id) {
		String sql = "delete * from order_items where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		jdbcTemplate.update(sql, param);
	}
	

}
