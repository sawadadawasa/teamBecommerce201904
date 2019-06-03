package com.example.repository;

import java.sql.Date;
import java.sql.Timestamp;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.OrderItem;

@Repository
@Transactional
public class OrderItemRepo]lsitory {
	
	@Autowired
	private org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate jdbcTemplate;
	
	private static final RowMapper<OrderItem> ORDERITEM_ROW_MAPPER = (rs, i) -> {
		int id = rs.getInt("id");
		int itemId = rs.getInt("item_id");
		int quantity = rs.getInt("quantity");
		return new OrderItem(id,  itemId, quantity) ;
	};
	
	public void save(OrderItem item) {
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		String sql = "INSERT INTO  order_items (id, itemId, quantity) VALUES (:id, :itemId, :quantity)";
		
		jdbcTemplate.update(sql, param);
				
	}

}
