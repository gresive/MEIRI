package com.meiri.jsp.review.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Review implements Serializable {

	private static final long serialVersionUID = 123123L;
	
	private int rcode;
	private String rcontent; // 제목
	private String rdate; // 리뷰 남긴 날짜
	private String userid; // 회원 아이디
	private int pcode; // 제품 번호
	private int fcode; // 파일 번호
	
	private ArrayList<productfile> productfile;
	
	public Review() {
		super();
	}

	public Review(int rcode, String rcontent, String rdate, int userid, int pcode, int fcode) {
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

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
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
