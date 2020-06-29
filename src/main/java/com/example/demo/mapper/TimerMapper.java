package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

public interface TimerMapper {
	String  getCronByid (@Param("id")int id);
}
