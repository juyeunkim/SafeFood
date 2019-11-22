package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.Member;

@Mapper
public interface MemberDAO {
	public Member search(String id);
	public List<Member> searchAll( );
	public void add(Member member);
	public void update(Member member);
	public void remove(String id);
	public String searchAllergy(String id);
}












