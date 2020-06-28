package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MoneyMapper;

@Service
public class MoneyServiceImpl implements MoneyService {
	@Autowired

	private MoneyMapper moneyMapper;

	@Override
	public Integer money_out(int money, int id) {
		// TODO Auto-generated method stub
		return moneyMapper.moneyout(money, id);
	}

	@Override
	public Integer money_in(int money, int id) {
		// TODO Auto-generated method stub
		return moneyMapper.moneyin(money, id);
	}

}
