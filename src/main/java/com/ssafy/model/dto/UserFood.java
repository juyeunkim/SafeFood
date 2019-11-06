package com.ssafy.model.dto;

public class UserFood {
	int no;
	String id;
	int code;
	public UserFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserFood(int no, String id, int code) {
		super();
		this.no = no;
		this.id = id;
		this.code = code;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "UserFood [no=" + no + ", id=" + id + ", code=" + code + "]";
	}
	
}
