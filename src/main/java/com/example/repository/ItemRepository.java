package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
		item.setDescription(rs.getString("description"));
		item.setImagePath(rs.getString("imagePath"));
		item.setDeleted(rs.getBoolean("deleted"));
		item.setPiece(rs.getInt("piece"));
		item.setOrigin(rs.getString("origin"));
		return item;
	};

	
	public List<Item> findAll(){
		String sql = "SELECT id, name, description, imagePath, deleted, piece, origin FROM items ORDER BY id";
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
	public void deleteItem(int id) {
		String sql = "delete * from order_items where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		template.update(sql, param);
	}
	
	
}
