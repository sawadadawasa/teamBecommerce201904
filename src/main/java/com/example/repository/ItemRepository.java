package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;


@Repository
@Transactional
public class ItemRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Item> itemRowMapper = (rs, i) ->{
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setContent(rs.getString("content"));
		return item;
	};
	
	public List<Item> findAll(){
		String sql = "SELECT id, name, content FROM articles ORDER BY id";
		List<Item> itemList = template.query(sql, itemRowMapper);
		return itemList;
	}
	/*
	public ArticleBulletinBoard save(ArticleBulletinBoard articleBulletinBoard){
		SqlParameterSource param = new BeanPropertySqlParameterSource(articleBulletinBoard);
		String insertSql = "INSERT INTO articles(name, content) VALUES(:name, :content)";
		template.update(insertSql, param);
		return articleBulletinBoard;
	}
	*/
	
	/*
	public void deleteById(ArticleBulletinBoard articleBulletinBoard){
		SqlParameterSource param = new BeanPropertySqlParameterSource(articleBulletinBoard);
		String deleteSql = "DELETE FROM articles WHERE id=:id";
		template.update(deleteSql, param);
	}
	*/
}
