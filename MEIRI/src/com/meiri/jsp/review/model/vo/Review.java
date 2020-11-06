package com.meiri.jsp.review.model.vo;

import java.sql.Date;

public class Review {

	private int rcode;
	private String rcontent;
	private Date rdate;
	private String userid;
	private int pcode;
	private int fcode;
	
	public Review() {
		super();
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
	
	

	public Review(int rcode, String rcontent, String userid) {
		super();
		this.rcode = rcode;
		this.rcontent = rcontent;
		this.userid = userid;
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
