package com.ssafy.vo;

public class SearchEngine {
	private int sno;
	private String search_key;
	private String search_value;
	int cnt;
	public SearchEngine() {
		super();
	}
	public SearchEngine(int sno, String search_key, String search_value, int cnt) {
		super();
		this.sno = sno;
		this.search_key = search_key;
		this.search_value = search_value;
		this.cnt = cnt;
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
				+ cnt + "]";
	}

	
}
