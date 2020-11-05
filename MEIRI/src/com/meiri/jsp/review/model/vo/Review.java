package com.kh.jsp.review.model.vo;

import java.io.Serializable;

public class Review implements Serializable {

	private static final long serialVersionUID = 123123L;
	
	private int rno;
	private String title; // 제목
	private String rcontent;
	private String rdate;
	private int mno; // 회원 아이디
	private int ano; // 관리자 아이디
	private int pno; // 제품 번호
	
	public Review() {
		super();
	}

	public Review(int rno, String title, String rcontent, String rdate, int mno, int ano, int pno) {
		super();
		this.rno = rno;
		this.title = title;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.mno = mno;
		this.ano = ano;
		this.pno = pno;
	}
	
	
	// 리뷰 작성 시 사용
	public Review(int rno, String title, String rcontent, int mno, int pno) {
		super();
		this.rno = rno;
		this.title = title;
		this.rcontent = rcontent;
		this.mno = mno;
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "Review [rno=" + rno + ", title=" + title + ", rcontent=" + rcontent + ", rdate=" + rdate + ", mno=" + mno
				+ ", ano=" + ano + "]";
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
	
	
	
}
