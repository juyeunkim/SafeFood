package com.ssafy.vo;

public class ConsumeException extends RuntimeException {
	public ConsumeException() {
		super("섭취 정보 처리 중 오류 발생");
	}
	public ConsumeException(String msg) {
		super(msg);
	}
}
