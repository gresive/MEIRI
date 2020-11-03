package com.meiri.jsp.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int rno;
	private String rtitle;
	private String rcontent;
	private Date rdate;
	private int rstar;
	private String userid;
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int rno, String rtitle, String rcontent, Date rdate, int rstar, String userid) {
		super();
		this.rno = rno;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rstar = rstar;
		this.userid = userid;
	}

	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
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

	public int getRstar() {
		return rstar;
	}

	public void setRstar(int rstar) {
		this.rstar = rstar;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	
}
