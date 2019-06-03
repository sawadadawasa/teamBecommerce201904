package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepository {
	
	//resultSetオブジェクトからUserオブジェクトに変換するためのクラス実装＆インスタンス化
	private static final RowMapper<User> User_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	//メールアドレスとパスワードからユーザー情報を取得
	//emailはメールアドレス
	//passwordはパスワード
	
	public User findOneByEmailAndPassword(String email,String password) {
		User user = null;
		try{
			// SQLインジェクション対策
			String sql = "SELECT id,name,email,password FROM users WHERE email = :email and password = :password";
			SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password",
					password);

			user = template.queryForObject(sql, param, User_ROW_MAPPER);
			return user;

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//メンバー情報を保存または更新する
	public User save(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		if (user.getId() == null) {
			template.update("INSERT INTO users(name,email,password,telephone) values(:name,:email,:password,:telephone)",
					param);
		} else {
			template.update(
					"UPDATE users SET name=:name, email=:email, password=:password, telephone=:telephone WHERE id=:id", param);
		}
		return user;
	
		
	}
	
	//メールアドレスを取得
	public List<User> findAll() {
		List<User> user=template.query("SELECT * FROM users",User_ROW_MAPPER);
		return user;
		
	}
	

}
