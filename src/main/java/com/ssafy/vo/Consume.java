package com.ssafy.vo;

/** 섭취 정보 */
public class Consume {
	private int num;
	private String id;
	private int code;
	private String fname;
	private String eatdate;
	private int count;
	public Consume() {
	}
	
	public Consume(String id, int code,String date, int count) {
		super();
		this.id = id;
		this.code = code;
		this.eatdate = date;
		this.count = count;
	}

	public Consume(int num, String id, int code, String fname, String eatdate, int count) {
		super();
		this.num = num;
		this.id = id;
		this.code = code;
		this.fname = fname; 
		this.eatdate = eatdate;
		this.count = count;
	}
	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getEatdate() {
		return eatdate;
	}
	public void setEatdate(String eatdate) {
		this.eatdate = eatdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Consume [num=" + num + ", id=" + id + ", code=" + code + ", fname=" + fname + ", eatdate=" + eatdate
				+ ", count=" + count + "]";
	}


}
