package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.FoodFrom;

@Mapper
public interface FoodFromDao {
	public void insertOrigin(FoodFrom food);
	public List<FoodFrom> searchOrigin(int fcode);
	public FoodFrom searchCountry(int ccode);
}
