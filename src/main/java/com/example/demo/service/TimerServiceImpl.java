package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enity.Timer;
import com.example.demo.mapper.TimerMapper;

@Service
public class TimerServiceImpl implements TimerService {

	 @Autowired
	 
	 TimerMapper timerMapper;
	@Override
	public String getCronByid(int id) {
		// TODO Auto-generated method stub
		return timerMapper.getCronByid(1);
	}

}
