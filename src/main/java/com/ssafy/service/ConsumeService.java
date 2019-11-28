package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Consume;

public interface ConsumeService {
	public void insert(Consume consume);
	public void delete(int num);
	public void update(Consume consume);
	public List<Consume> search(String id);
	public List<Consume> count(String id);
	public List<Consume> searchAll(String id);
	public List<Consume> searchAllweek(String id);
}
