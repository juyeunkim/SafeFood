package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.SearchEngine;

public interface SearchEngineService {
	public List<SearchEngine> searchAll();
	public int getSearchNo();
	public SearchEngine count();
}
