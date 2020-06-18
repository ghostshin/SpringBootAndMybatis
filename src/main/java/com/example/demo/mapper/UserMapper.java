package com.example.demo.mapper;

import java.util.List;

import com.example.demo.enity.User;

public interface UserMapper {
	Integer insert(User u);

	List<User> findAll();

	List<User> findByUserIds(List<Integer> userIds);
}
