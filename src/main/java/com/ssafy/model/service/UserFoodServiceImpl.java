package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dao.UserFoodDAO;
import com.ssafy.model.dao.UserFoodDAOImpl;
import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.UserFood;

public class UserFoodServiceImpl implements UserFoodService {
	UserFoodDAO dao = new UserFoodDAOImpl();
	
	public UserFoodDAO getDao() {
		return dao;
	}

	public void setDao(UserFoodDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Food> search(String id) throws SQLException {
		try {
			return dao.search(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(UserFood userfood) throws SQLException {
		try {
			dao.add(userfood);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int code) throws SQLException {
		try {
			dao.delete(code);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int count(String id) throws SQLException {
		try {
			return dao.count(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
