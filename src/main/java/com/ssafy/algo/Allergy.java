package com.ssafy.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.Food;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.FoodService;
import com.ssafy.model.service.FoodServiceImpl;
import com.ssafy.model.service.UserService;
import com.ssafy.model.service.UserServiceImp;

public class Allergy {
	private static List<Food> list = new LinkedList<>();
	private static FoodService foodService = new FoodServiceImpl();
	private static List<String> choiceList= new LinkedList<>(); 

	static Food[] choice;
	static boolean[] check;
	public static void main(String[] args) {
		System.out.println(makeSet(4,2400));
	}
	
	public static List<String> makeSet(int n, double maxCal) {
		PageBean bean = new PageBean();
		bean.setKey("all");
		list =  foodService.searchAll(bean);
		System.out.println(list);
		choice = new Food[n];
		check=new boolean[list.size()];

		
		permu(n,maxCal,0,0);
		
		
		
		
		return choiceList;
		
	}

	private static void permu(int n, double maxCal, int IDX,double nowCal) {
		if(nowCal>maxCal)return;
		if(IDX==n) {
			StringBuilder sb = new StringBuilder();
			if(nowCal<maxCal) {
				for(int i=0; i<n; i++) {
					System.out.print(choice[i].getName()+" : "+choice[i].getCalory()+" ");
					sb.append(choice[i].getName()).append(",");
				}
			}
			System.out.println();
			choiceList.add(sb.toString());
			
			
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(!check[i]) {
				check[i]=true;
				choice[IDX]=list.get(i);
				permu(n, maxCal, IDX+1, nowCal+list.get(i).getCalory());
				check[i]=false;
			}
		}
		
	}
}
