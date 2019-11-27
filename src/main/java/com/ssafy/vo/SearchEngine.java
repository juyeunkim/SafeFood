package com.ssafy.vo;

public class SearchEngine {
	private int sno;
	private String search_key;
	private String search_value;
	private int cnt;
	private String search_date;
	public SearchEngine() {
		super();
	}
	public String getSearch_date() {
		return search_date;
	}
	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}
	public SearchEngine(String search_key, String search_value,String search_date) {
		super();
		this.search_key = search_key;
		this.search_value = search_value;
		this.search_date=search_date;
	}
	public SearchEngine(int sno, String search_key, String search_value, int cnt, String search_date) {
		super();
		this.sno = sno;
		this.search_key = search_key;
		this.search_value = search_value;
		this.cnt = cnt;
		this.search_date=search_date;
	}
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSearch_key() {
		return search_key;
	}
	public void setSearch_key(String search_key) {
		this.search_key = search_key;
	}
	public String getSearch_value() {
		return search_value;
	}
	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}
	@Override
	public String toString() {
		return "SearchEngine [sno=" + sno + ", search_key=" + search_key + ", search_value=" + search_value + ", cnt="
				+ cnt + ", search_date=" + search_date + "]";
	}
	

	
}
