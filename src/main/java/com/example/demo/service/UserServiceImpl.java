package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enity.User;
import com.example.demo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	    private UserMapper userMapper;
	@Override
	public Integer insert(User u) {
		// TODO Auto-generated method stub
		return userMapper.insert(u);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		 return userMapper.findAll();
	}

	@Override
	public List<User> findByUserIds(List<Integer> userIds) {
		// TODO Auto-generated method stub
		 return userMapper.findByUserIds(userIds);
	}

}
