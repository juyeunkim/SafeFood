package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vo.Consume;
import com.ssafy.vo.ConsumeException;

@Service
public class ConsumeServiceImpl implements ConsumeService{
	@Autowired
	private ConsumeServiceImpl cao;
	
	public List<Consume> searchAll(String id) {
		try{
			return cao.searchAll(id);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 리스트 조회 중 에러 발생");
		}
	} 
	public void insert(Consume consume) {
		try {
			cao.insert(consume);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 추가 중 에러 발생");
		}
	}
	@Override
	public void delete(int num) {
		try {
			cao.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 삭제 중 에러 발생");
		}
	}
	
	@Override
	public void update(Consume consume) {
		try {
			cao.update(consume);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConsumeException("섭취 정보 업데이트 중 에러 발생");
		}
		
	}
}
  