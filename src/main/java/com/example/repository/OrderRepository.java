package com.example.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@Repository
@Transactional
public class OrderRepository {
	

	@Autowired
	private org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate jdbcTemplate;
	/**
	 * ResultSetオブジェクトからOrderオブジェクトに変換するためのクラス実装&インスタンス化
	 */
	private static final RowMapper<Order> ORDER_ROW_MAPPER = (rs, i) -> {
		Integer id = rs.getInt("id");
		Integer userId = rs.getInt("user_id");
		Integer totalPrice = rs.getInt("total_price");
		Date orderDate = rs.getDate("order_date");
		String destinationName = rs.getString("destination_name");
		String destinationEmail = rs.getString("destination_email");
		String destinationAddress = rs.getString("destination_address");
		String destinationTel = rs.getString("destination_tel");
		Timestamp deliveryTime = rs.getTimestamp("delivery_time");
		Integer paymentMethod = rs.getInt("payment_method");
		String postalCode = rs.getString("postal_code");
		return new Order( id,  userId,  totalPrice, orderDate, 
				 destinationName, destinationEmail, destinationAddress,
				 destinationTel, deliveryTime, paymentMethod,postalCode) ;

	};

	public List<Order> findByUserId(int userId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId);
		return jdbcTemplate.query("select * from orders where user_id =:userId"
				, param, ORDER_ROW_MAPPER);
	}
	public void saveFix(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		String sql = "insert into orders (user_id,total_price,order_date,destination_name,destination_email,"+
					   "destination_address,destination_tel,delivery_time,payment_method,postal_code)"+
					  "values(:userId,:totalPrice,:orderDate,:destinationName,:destinationEmail,"+
	                      ":destinationAddress,:destinationTel,:deliveryTime,:paymentMethod,:postalCode)";
		
		jdbcTemplate.update(sql,param);		
	}
	public void deleteOrder(int orderId) {
		String sql = "delete from order_items where order_id =:orderId";
		String sql2 = "delete from orders where id =:orderId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderId",orderId);
		jdbcTemplate.update(sql, param);
		jdbcTemplate.update(sql2, param);
	}
	
	public Integer booleanDeleteOrNot(int orderId,Date now) {
		String sql = "select count(*) from orders where  delivery_time + '-3days' > :now and id = :orderId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderId",orderId).addValue("now",now);	
		return jdbcTemplate.queryForObject(sql,param,Integer.class);
	}
	
}

