package com.ssafy.model.dto;

public class FoodException extends RuntimeException {
	public FoodException() {
		super("푸드 처리 중 오류 발생");
	}
	public FoodException(String msg) {
		super(msg);
	}
}
