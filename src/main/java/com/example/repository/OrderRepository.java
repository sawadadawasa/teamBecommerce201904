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
		return new Order( id,  userId,  totalPrice, orderDate, 
				 destinationName, destinationEmail, destinationAddress,
				 destinationTel, deliveryTime, paymentMethod) ;

	};

	public List<Order> findByUserId(int userId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId);
		return jdbcTemplate.query("select * from orders where user_id =:userId"
				, param, ORDER_ROW_MAPPER);
	}
	public void saveFix(Order order) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);
		String sql = "insert into orders (user_id,total_price,order_date,destination_name,destination_email,"+
					   "destination_address,destination_tel,delivery_time,payment_method)"+
					  "values(:userId,:totalPrice,:orderDate,:destinationName,:destinationEmail,"+
	                      ":destinationAddress,:destinationTel,:deliveryTime,:paymentMethod)";
		
		jdbcTemplate.update(sql,param);		
	}
	
}

