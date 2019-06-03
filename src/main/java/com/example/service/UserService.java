package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	public User findOneByEmailAndPassword(String email,String password) {
		return userrepository.findOneByEmailAndPassword(email,password);
	}
	
	public User save(User user) {
		return userrepository.save(user);
	}
	
	public List<User> findAll(){
		return userrepository.findAll();
	}
	
	
	

}
