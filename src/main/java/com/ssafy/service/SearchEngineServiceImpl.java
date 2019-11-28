package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.SearchEngineDao;
import com.ssafy.vo.ConsumeException;
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

	@Override
	public void insert(SearchEngine searchengine) {
		try {
			sao.insert(searchengine);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("검색한 정보 추가 중 에러 발생");
		}
		
	}

	@Override
	public List<SearchEngine> searchAllday() {
		try {
			return sao.searchAllday();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("검색정보 하루 조회 중 에러 발생");
		}
	}

	@Override
	public List<SearchEngine> searchAllweek() {
		try {
			return sao.searchAllweek();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("검색정보 일주일 조회 중 에러 발생");
		}
	}

	@Override
	public List<SearchEngine> searchAllmonth() {
		try {
			return sao.searchAllmonth();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("검색정보 한달 조회 중 에러 발생");
		}
	}
} 
