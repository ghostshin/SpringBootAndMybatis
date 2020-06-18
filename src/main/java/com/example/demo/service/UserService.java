package com.example.demo.service;

import java.util.List;

import com.example.demo.enity.User;

public interface UserService {
	Integer insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> userIds);
}
