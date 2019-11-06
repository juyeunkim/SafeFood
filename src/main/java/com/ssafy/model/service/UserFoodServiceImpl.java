package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserFoodDAO;
import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.UserFood;

@Service
public class UserFoodServiceImpl implements UserFoodService {
	@Autowired
	UserFoodDAO dao;
	
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
