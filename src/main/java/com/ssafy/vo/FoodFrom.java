package com.ssafy.vo;

public class FoodFrom {
	int fcode;
	int ccode;
	String country;
	
	public FoodFrom() {}
	public FoodFrom(int fcode, int ccode) {
		super();
		this.fcode = fcode;
		this.ccode = ccode;
	}
	
	
	public FoodFrom(int ccode, String country) {
		super();
		this.ccode = ccode;
		this.country = country;
	}
	public int getFood() {
		return fcode;
	}
	public void setFood(int fcode) {
		this.fcode = fcode;
	}
	public int getCountry() {
		return ccode;
	}
	public void setCountry(int ccode) {
		this.ccode = ccode;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "FoodFrom [fcode=" + fcode + ", ccode=" + ccode + ", country=" + country + "]";
	}
	
	
	
	
	
	
}
