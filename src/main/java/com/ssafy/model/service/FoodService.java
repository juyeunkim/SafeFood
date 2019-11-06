package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.PageBean;

public interface FoodService {
	public Food search(int code);
	public List<Food> searchAll(PageBean bean);
	public void insertFood(Food food);
	public void updateFood(Food food);
	public void deleteFood(int code);
	public int foodCount(PageBean bean);
}
