package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.Consume;

@Mapper
public interface ConsumeDao {
	public void insert(Consume consume);
	public void delete(int num);
	public void update(Consume consume);
	public List<Consume> search(String id);
	public List<Consume> searchAll(String id);
	public List<Consume> count(String id);
	public List<Consume> searchAllweek(String id);
}
