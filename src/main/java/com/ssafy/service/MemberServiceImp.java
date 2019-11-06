package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.MemberDAO;
import com.ssafy.vo.Member;
import com.ssafy.vo.MemberException;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	private MemberDAO dao;

	public Member search(String id) {
		try {
			return dao.search(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MemberException("회원 정보 검색 중 오류 발생");
		}
	}

	public List<Member> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			throw new MemberException("회원 목록 검색 중 오류 발생");
		}
	}

	public boolean login(String id, String pw) {
		try {
			Member member = dao.search(id);
			System.out.println(member);
			if (member == null) {
				throw new MemberException("등록되지 않은 회원 아이디입니다.");
			} else {
				if (pw.equals(member.getPassword())) {
					return true;
				} else {
					System.out.println(member.getPassword());
					throw new MemberException("비밀 번호 오류");
				}
			}
		} catch (Exception e) {
			if (e instanceof MemberException) {
				throw e;
			} else {
				throw new MemberException("로그인 처리 중 오류 발생");
			}
		}
	}

	public boolean checkID(String id) {
		try {
			Member member = dao.search(id);
			if (member == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new MemberException("아이디 검사 중 오류 발생");
		}
	}

	public void add(Member member) {
		try {
			Member find = dao.search(member.getId());
			if (find != null) {
				throw new MemberException("이미 등록된 아이디입니다.");
			} else {
				dao.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MemberException("회원 정보 등록 중 오류 발생");
		}
	}

	public void update(Member member) {
		try {
			Member find = dao.search(member.getId());
			if (find == null) {
				throw new MemberException("수정할 회원 정보가 없습니다.");
			} else {
				dao.update(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MemberException("회원 정보 수정 중 오류 발생");
		}
	}

	public void remove(String id) {
		try {
			Member find = dao.search(id);
			if (find == null) {
				throw new MemberException("탈퇴할 회원 정보가 없습니다.");
			} else {
				dao.remove(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MemberException("회원 탈퇴 처리 중 오류 발생");
		}
	}

}
