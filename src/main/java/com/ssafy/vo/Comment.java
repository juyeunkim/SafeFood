package com.ssafy.vo;

public class Comment {
	private int cno;
	private int qno;
	private String id;
	private String cregdate;
	private String comment;
	
	
	public Comment() {
		super();
	}

	public Comment(int cno, int qno, String id, String cregdate, String comment) {
		super();
		this.cno = cno;
		this.qno = qno;
		this.id = id;
		this.cregdate = cregdate;
		this.comment = comment;
	}
	
	public Comment(int qno, String id, String comment) {
		super();
		this.qno = qno;
		this.id = id;
		this.comment = comment;
	}
	

	@Override
	public String toString() {
		return "Commnent [cno=" + cno + ", qno=" + qno + ", id=" + id + ", cregdate=" + cregdate + ", comment=" + comment
				+ "]";
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCregdate() {
		return cregdate;
	}

	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
