package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vo.Consume;

@Service
public class ConsumeServiceImpl implements ConsumeService{
	@Autowired
	private ConsumeServiceImpl cao;
	public List<Consume> search(String id) {
		try{
			return cao.search(id);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	} 
	public void insert(Consume consume) {
		
	}
	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}
}
  