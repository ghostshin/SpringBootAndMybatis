package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

public interface MoneyMapper {
	Integer moneyout (@Param("money")int money,@Param("id")int id);
	
	Integer moneyin  (@Param("money")int money,@Param("id")int id);
}
