package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Member;


public interface MemberService {
	public Member search(String id);
	public List<Member> searchAll();
	public boolean login(String id, String pw);
	public boolean checkID(String id);
	public void add(Member member);
	public void update(Member member);
	public void remove(String id);
	public String searchAllergy(String id);
}
