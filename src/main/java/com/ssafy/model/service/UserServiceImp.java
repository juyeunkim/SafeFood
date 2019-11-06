package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.UserDAO;
import com.ssafy.model.dao.UserDAOImp;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.User;
import com.ssafy.model.dto.UserException;

public class UserServiceImp implements UserService {
	UserDAO dao = new UserDAOImp();
	
	public UserServiceImp() {
		super();
	}

	public UserServiceImp(UserDAO dao) {
		super();
		this.dao = dao;
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public User search(String id) {
		try {
			User user = dao.search(id);
			if(user == null) {
				throw new UserException("등록되지 않은 아이디입니다.");
			}else {
			   return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException();
		}
	}

	public List<User> searchAll(PageBean bean) {
		try {
			return dao.searchAll(bean);
		}catch (SQLException e) {
			throw new UserException();
		}
	}

	public boolean login(String id, String pw) {
		try {
			User user = dao.search(id);
			if(user == null) {
				throw new UserException("등록되지 않은 회원 아이디입니다.");
			}else {
				if(pw.equals(user.getPassword())) {
					return true;
				}else {
					throw new UserException("비밀 번호 오류");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException();
		}
	}

	public boolean checkID(String id) {
		try {
			User user = dao.search(id);
			if(user == null) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			throw new UserException();
		}
	}
	public void add(User user) {
		try {
			User find = dao.search(user.getId());
			if(find != null) {
				throw new UserException("이미 등록된 아이디입니다.");
			}else {
				dao.add(user);
			}
		} catch (SQLException e) {
			throw new UserException();
		}
	}
	public void update(User user) {
		try {
			User find = dao.search(user.getId());
			if(find == null) {
				throw new UserException("수정할 회원 정보가 없습니다.");
			}else {
				dao.update(user);
			}
		} catch (SQLException e) {
			throw new UserException();
		}
	}

	public void remove(String id) {
		try {
			User find = dao.search(id);
			if(find == null) {
				throw new UserException("탈퇴할 회원 정보가 없습니다.");
			}else {
				dao.remove(id);
			}
		} catch (SQLException e) {
			throw new UserException();
		}
	}

	public String getAllergy(String id) {
		try {
			String allergy = dao.search(id).getAllergy();
			return allergy;
		} catch (SQLException e) {
			throw new UserException();
		}
	}
}
