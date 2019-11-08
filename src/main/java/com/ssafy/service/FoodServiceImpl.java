package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.FoodDao;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.SafeFoodException;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDao dao;
	private String[] allergys={"대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"};

	public FoodServiceImpl() {
	}
	public List<Food> searchAll(FoodPageBean bean) {
		try {
			return dao.searchAll(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SafeFoodException("전체 목록 조회 중 오류 발생");
		}
		
	}
	public Food search(int code) {
		//  code에  맞는 식품 정보를 검색하고, 검색된 식품의 원재료에 알레르기 성분이 있는지 확인하여 Food 정보에 입력한다.
		try {
			Food f = dao.search(code);
			String metarial = f.getMaterial();
			System.out.println("metarial  "+metarial);
			String alle = "";
			for (int i = 0; i < allergys.length; i++) {
				if (metarial.contains(allergys[i])) {
					alle += allergys[i] + " ";
				}
			}
			if(alle.equals("")) f.setAllergy("없습니다.");
			else				f.setAllergy(alle);
			return f;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SafeFoodException("상품 조회 중 오류 발생");
		}
		
	}
	public List<Food> searchBest() {
		return dao.searchBest();
	}
	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}
}
