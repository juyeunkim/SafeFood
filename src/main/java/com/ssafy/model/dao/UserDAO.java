package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.User;

public interface UserDAO {
	public User search(String id) throws SQLException;
	public List<User> searchAll(PageBean bean) throws SQLException;
	public void add(User user)	 throws SQLException;
	public void update(User user)throws SQLException;
	public void remove(String id)    throws SQLException;
}












