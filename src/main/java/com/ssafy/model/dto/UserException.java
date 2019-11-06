package com.ssafy.model.dto;

public class UserException extends RuntimeException {
	public UserException() {
		super("회원 정보 처리 중 오류 발생");
	}
	public UserException(String msg) {
		super(msg);
	}
}
