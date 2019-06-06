package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findOneByEmailAndPassword(String email,String password) {
		return userRepository.findOneByEmailAndPassword(email,password);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public String findPassword(String email) {
		return userRepository.findPassword(email);
	}
	
	public void deleteUserInfo(String email) {
		userRepository.deleteUserInfo(email);
	}

}
