package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		user.setAddress(rs.getString("address"));
		user.setPostalCode(rs.getString("postal_code"));
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
			String sql = "SELECT * FROM users WHERE email = :email and password = :password";
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("email", email)
					.addValue("password", password);
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
			//エンコードオブジェクト作成
			BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
			//パスワードを暗号化
			String encoPassword = enco.encode(user.getPassword());
			user.setPassword(encoPassword);
			String insertSql="INSERT INTO users(name,email,password,address,telephone) VALUES(:name,:email,:password,:address,:telephone)";
			template.update(insertSql, param);
		} else {
			String updateSql=
					"UPDATE users SET name=:name, email=:email, password=:password, address=:address, telephone=:telephone,postal_code =:postalCode WHERE id=:id";
			template.update(updateSql,param);
		}
		return user;
	}
	
	//メールアドレスを取得
	public List<User> findAll() {
		List<User> users=template.query("SELECT * FROM users",User_ROW_MAPPER);
		return users;
	}
	
	//メールアドレスからDBにある暗号PWを取得.
	public String findPassword(String email) {
		try {
			SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
			String sql = "SELECT password FROM users WHERE email = :email";
			return template.queryForObject(sql, param, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//ユーザー情報を削除する
	public void deleteUserInfo(String email) {
		try{
		String sql = "DELETE FROM users WHERE email = :email";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);

		template.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
