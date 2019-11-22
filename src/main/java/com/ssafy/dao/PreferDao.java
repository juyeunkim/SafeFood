package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.Consume;
import com.ssafy.vo.Prefer;

@Mapper
public interface PreferDao {
	public List<Prefer> search(String id);
	public void insert(Prefer prefer);
	public void delete(int num);
	public List<Prefer> searchAll(String id);
	public void update(Prefer prefer);
	public List<Prefer> count(String id);
}
