package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.Consume;

@Mapper
public interface ConsumeDao {
	public List<Consume> search(String id);
	public void insert(Consume consume);
	public void delete(int num);
}
