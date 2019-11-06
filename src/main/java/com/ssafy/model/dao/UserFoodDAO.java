package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.UserFood;

@Mapper
public interface UserFoodDAO {
	public List<Food> search(String id) ;
	public void add(UserFood userfood) ;
	public void delete(int code) ;
	public int count(String id);
}
