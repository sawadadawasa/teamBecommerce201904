package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	public void deleteId(int id) {
		String sql = "delete * from order_items where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		template.update(sql, param);
	}
	
}
