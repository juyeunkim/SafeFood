package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.User;

public interface UserService {
	public User search(String id);
	public List<User> searchAll(PageBean bean);
	public boolean login(String id, String pw);
	public boolean checkID(String id);
	public void add(User user);
	public void update(User user); //알레르기 추가
	public void remove(String id);
	public String getAllergy(String id);
}
