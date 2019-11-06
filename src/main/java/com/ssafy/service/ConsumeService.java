package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Consume;

public interface ConsumeService {
	public List<Consume> search(String id);
	public void insert(Consume consume);
	public void delete(int num);
}
