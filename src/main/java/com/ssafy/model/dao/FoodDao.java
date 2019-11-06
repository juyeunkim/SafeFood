package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.PageBean;

@Mapper
public interface FoodDao {	
	
	public Food search(int code);
	public List<Food> searchAll(PageBean bean) ;
	public int foodCount(PageBean bean);
	public void insertFood(Food food);
	public void updateFood(Food food);
	public void deleteFood(int code);
}
