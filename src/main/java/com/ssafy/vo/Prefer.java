package com.ssafy.vo;

/** 섭취 정보 */
public class Prefer {
	protected int num;
	protected String id;
	protected int code;
	protected String fname;
	protected String preferdate;
	protected int count;
	public Prefer() {
	}
	
	public Prefer(String id, int code,String preferdate, int count) {
		super();
		this.id = id;
		this.code = code;
		this.preferdate = preferdate;
		this.count = count;
	}

	public Prefer(int num, String id, int code, String fname, String preferdate, int count) {
		super();
		this.num = num;
		this.id = id;
		this.code = code;
		this.fname = fname; 
		this.preferdate = preferdate;
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
	
	public String getPreferdate() {
		return preferdate;
	}

	public void setPreferdate(String preferdate) {
		this.preferdate = preferdate;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Prefer [num=" + num + ", id=" + id + ", code=" + code + ", fname=" + fname + ", preferdate=" + preferdate
				+ ", count=" + count + "]";
	}


}
