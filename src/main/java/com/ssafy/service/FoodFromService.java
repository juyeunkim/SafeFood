package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.FoodFrom;

public interface FoodFromService {
	public void insertOrigin(FoodFrom food);
	public List<FoodFrom> searchOrigin(int fcode);
	public FoodFrom searchCountry(int ccode);
}
