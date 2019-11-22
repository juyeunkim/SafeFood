package com.ssafy.vo;

public class PreferException extends RuntimeException {
	public PreferException() {
		super("찜한 정보 처리 중 오류 발생");
	}
	public PreferException(String msg) {
		super(msg);
	}
}
