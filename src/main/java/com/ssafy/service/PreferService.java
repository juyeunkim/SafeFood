package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Consume;
import com.ssafy.vo.Prefer;

public interface PreferService {
	public Prefer search(int num);
	public void insert(Prefer prefer);
	public void delete(int num);
	public List<Prefer> searchAll(String id);
	public void update(Prefer prefer);
	public List<Prefer> count(String id);
}
