package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.SearchEngineDao;
import com.ssafy.vo.SearchEngine;
@Service
public class SearchEngineServiceImpl implements SearchEngineService {
	@Autowired
	SearchEngineDao sao;
	@Override
	public List<SearchEngine> searchAll() {
		return sao.searchAll();
	}

	@Override
	public int getSearchNo() {
		return sao.getSearchNo();
	}

	@Override
	public List<SearchEngine> count() {
		return sao.count();
	}
} 
