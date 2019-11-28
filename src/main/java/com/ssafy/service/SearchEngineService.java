package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.SearchEngine;

public interface SearchEngineService {
	public List<SearchEngine> searchAll();
	public int getSearchNo();
	public List<SearchEngine> count();
	public void insert(SearchEngine searchengine);
	public List<SearchEngine> searchAllday();
	public List<SearchEngine> searchAllweek();
	public List<SearchEngine> searchAllmonth();
}
