package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.enity.User;
import com.example.demo.service.MoneyService;
import com.example.demo.service.UserService;

@RequestMapping("student")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	
	private MoneyService moneyService;

	@RequestMapping("save")
	public String save() {
		User user = new User();
		user.setUserId(new Random().nextInt(1000) + 1);
		user.setName("张三" + user.getUserId());
		user.setAge(new Random().nextInt(80) + 1);
		userService.insert(user);
		return user.getName() + "创建成功！";
	}

	@RequestMapping("select")
	public String select() {
		List<User> a = userService.findAll();

//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < a.size(); i++) {
//			sb.append("姓名：");
//			sb.append(a.get(i).getName());
//			sb.append("；年龄：");
//			sb.append(a.get(i).getAge());
//			sb.append("；序号：");
//			sb.append(a.get(i).getId());
//			sb.append("！！！！");
//
//		}

		String json = JSON.toJSONString(a);
		
		return json;

	}
	//事务管理
	@Transactional
	@RequestMapping("deal")
	public String deal() {
		
		moneyService.money_out(200, 1);
		//出现异常，回滚
		int i = 1/0;
		
		moneyService.money_in(200, 2);

		return null;
		
		
		
	}
	
	
	
}
