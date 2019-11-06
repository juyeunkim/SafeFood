package com.ssafy.vo;

/** 섭취 정보 */
public class Consume {
	protected int num;
	protected String id;
	protected int code;
	protected String eatdate;
	protected int count;
	public Consume() {
	}
	
	
	public Consume(int num, String id, int code, String eatdate, int count) {
		this.num = num;
		this.id = id;
		this.code = code;
		this.eatdate = eatdate;
		this.count = count;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Consume [num=").append(num).append(", id=").append(id).append(", code=").append(code)
				.append(", eatdate=").append(eatdate).append(", count=").append(count).append("]");
		return builder.toString();
	}
	

}
