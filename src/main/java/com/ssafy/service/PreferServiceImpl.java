package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.ConsumeDao;
import com.ssafy.dao.PreferDao;
import com.ssafy.vo.Consume;
import com.ssafy.vo.ConsumeException;
import com.ssafy.vo.Prefer;

@Service
public class PreferServiceImpl implements PreferService{
	@Autowired
	private PreferDao pao;
	
	public List<Prefer> searchAll(String id) {
		try{
			return pao.searchAll(id);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 리스트 조회 중 에러 발생");
		}
	} 
	public void insert(Prefer prefer) {
		try {
			pao.insert(prefer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 추가 중 에러 발생");
		}
	}
	@Override
	public void delete(int num) {
		try {
			pao.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 삭제 중 에러 발생");
		}
	}
	
	@Override
	public void update(Prefer prefer) {
		try {
			pao.update(prefer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 업데이트 중 에러 발생");
		}
		
	}
	@Override
	public List<Prefer> count(String id) {
		try {
			return pao.count(id);			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취  top 5 중 에러 발생");
		}
	}
	@Override
	public List<Prefer> search(String id) {
		try{
			return pao.search(id);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 리스트 조회 중 에러 발생");
		}
	}
}
  