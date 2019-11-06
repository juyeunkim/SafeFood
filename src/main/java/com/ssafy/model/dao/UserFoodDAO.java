package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.UserFood;

public interface UserFoodDAO {
	public List<Food> search(String id) throws SQLException;
	public void add(UserFood userfood) throws SQLException;
	public void delete(int code) throws SQLException;
	public int count(String id) throws SQLException;
}
