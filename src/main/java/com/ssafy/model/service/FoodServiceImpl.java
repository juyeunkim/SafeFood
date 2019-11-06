package com.ssafy.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dao.FoodDao;
import com.ssafy.model.dao.FoodDaoImpl;
import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.FoodException;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;
import com.ssafy.util.PageUtility;

public class FoodServiceImpl implements FoodService{
	private FoodDao dao = new FoodDaoImpl();
	private String[] allergys={"대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"};
	

	public FoodDao getDao() {
		return dao;
	}
	public void setDao(FoodDao dao) {
		this.dao = dao;
	}
	public Food search(int code) {
		try {
			return dao.search(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Food> searchAll(PageBean bean) {
		try {
			int total = dao.foodCount(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPagelink(bar.getPageBar());
			return dao.searchAll(bean);
		} catch (Exception e) {
			e.printStackTrace();
//			throw new FoodException("게시물 전체 중 오류 발생");
		}
		return null;
	}
	public void insertFood(Food food) {
		try {
			dao.insertFood(food);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FoodException("푸드 추가 중 오류 발생");
		}
	}
	public void updateFood(Food food) {
		
		try {
			dao.updateFood(food);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FoodException("푸드 업데이트 중 오류 발생");
		}
	}
	public void deleteFood(int code) {
		try {
			dao.deleteFood(code);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FoodException("푸드 삭제 중 오류 발생");
		}
	}
	public int foodCount(PageBean bean) {
		return dao.foodCount(bean);
	}
}
