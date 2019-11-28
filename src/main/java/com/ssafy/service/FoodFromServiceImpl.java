package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.FoodFromDao;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodFrom;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.SafeFoodException;

@Service
public class FoodFromServiceImpl implements FoodFromService {
	@Autowired
	private FoodFromDao dao;
	
	@Override
	public void insertOrigin(FoodFrom food) {
		try {
			dao.insertOrigin(food);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SafeFoodException("원산지 추가중 에러 발생");
		}
	}

	@Override
	public List<FoodFrom> searchOrigin(int fcode) {
		try {
			return dao.searchOrigin(fcode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SafeFoodException("원산지 조회 중 에러 발생");
		}
	}
	
	@Override
	public FoodFrom searchCountry(int ccode) {
		try {
			return dao.searchCountry(ccode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SafeFoodException("국가 조회 중 에러 발생");
		}
	}
	

}
