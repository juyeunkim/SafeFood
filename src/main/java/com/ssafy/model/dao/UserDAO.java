package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.User;

@Mapper
public interface UserDAO {
	public User search(String id);
	public List<User> searchAll(PageBean bean);
	public void add(User user);
	public void update(User user);
	public void remove(String id);
}












