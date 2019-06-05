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

		String name = rs.getString("name");
		int price = rs.getInt("price");
		String imagePATH = rs.getString("imagePATH");
		String piece = rs.getString("piece");
		int quantity = rs.getInt("quantity");
		int subTotalPrice = rs.getInt("subTotalPrice");
		int id = rs.getInt("id");
		int itemId = rs.getInt("item_id");
		orderItem.setName(name);
		orderItem.setPrice(price);
		orderItem.setImagePATH(imagePATH);
		orderItem.setPiece(piece);
		orderItem.setQuantity(quantity);
		orderItem.setSubTotalPrice(subTotalPrice);
		orderItem.setId(id);
		orderItem.setItemId(itemId);
		return orderItem;
	};

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("order_items");
	}

	public List<OrderItem> findAll(Integer orderId){

		String sql = "SELECT order_items.id, items.name, items.price, items.imagePATH, items.piece, order_items.quantity,"
				+ " items.id AS item_id, items.price * order_items.quantity AS subTotalPrice"
				+ " FROM order_items INNER JOIN items ON order_items.item_id = items.id WHERE order_id = :orderId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderId);
		orderItemList = jdbcTemplate.query(sql, param, ORDERITEM_ROW_MAPPER);

		return orderItemList;

	}
	public List<OrderItem> findAllHistoryDetail(Integer orderId){

		String sql = "SELECT order_items.id, items.name, items.price, items.imagePATH, items.piece, order_items.quantity,"
				+ " items.id AS item_id, items.price * order_items.quantity AS subTotalPrice"
				+ " FROM order_items INNER JOIN items ON order_items.item_id = items.id WHERE order_id = :orderId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderId);
		orderItemList = jdbcTemplate.query(sql, param, ORDERITEM_ROW_MAPPER);

		return orderItemList;

	}

	public Integer saveAndReturnOrderId(int itemId,  int quantity) {

		String selectSql = "SELECT max(order_id)+1 FROM order_items";

		Integer orderId = jdbcTemplate2.queryForObject(selectSql,  Integer.class);

		if(orderId == null) {
			orderId = 1;
			System.out.println(orderId);
		}

		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId",itemId).addValue("quantity", quantity).addValue("orderId", orderId);

		String insertSql = "INSERT INTO order_items (item_id, order_id, quantity)VALUES (:itemId, :orderId, :quantity)";

		jdbcTemplate.update(insertSql, param);

		return orderId;

	}

	public void saveOnly (int itemId, int quantity) {

		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId",itemId).addValue("orderId", session.getAttribute("orderId")).addValue("quantity", quantity);

		String insertSql = "INSERT INTO order_items (item_id, order_id, quantity) VALUES (:itemId, :orderId, :quantity)";

		jdbcTemplate.update(insertSql, param);

	}

	public void deleteId(int itemId, int id) {
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId", itemId).addValue("id", id);
		
		String deleteSql = "DELETE FROM order_items WHERE item_id = :itemId AND id = :id";
		
		jdbcTemplate.update(deleteSql, param);
	}
	
	public void update(int itemId, int addQuantity) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId",itemId).addValue("addQuantity", addQuantity);
		
		String updateSql ="UPDATE order_items SET quantity = quantity + :addQuantity  WHERE item_id = :itemId" ;

		jdbcTemplate.update(updateSql, param);
		
	}


}
