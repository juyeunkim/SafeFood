package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.SearchEngine;

@Mapper
public interface SearchEngineDao {
	public List<SearchEngine> searchAll();
	public int getSearchNo();
	public List<SearchEngine> count();
	public void insert(SearchEngine searchengine);
	public List<SearchEngine> searchAllday();
	public List<SearchEngine> searchAllweek();
	public List<SearchEngine> searchAllmonth();
}
