package com.meiri.jsp.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable {

	private static final long serialVersionUID = 123123L;
	
	private int rcode; // 리뷰 코드
	private String rcontent; // 리뷰 내용
	private Date rdate; // 리뷰 작성 날짜
	private String userid; // 회원 아이디
	private int pcode; // 상품코드
	private int fcode; // 파일코드
	
	public Review() {
	}

	public Review(int rcode, String rcontent, Date rdate, String userid, int pcode, int fcode) {
		super();
		this.rcode = rcode;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.userid = userid;
		this.pcode = pcode;
		this.fcode = fcode;
	}

	@Override
	public String toString() {
		return "Review [rcode=" + rcode + ", rcontent=" + rcontent + ", rdate=" + rdate + ", userid=" + userid
				+ ", pcode=" + pcode + ", fcode=" + fcode + "]";
	}

	public int getRcode() {
		return rcode;
	}

	public void setRcode(int rcode) {
		this.rcode = rcode;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
	}
	

	
	
	
	
}