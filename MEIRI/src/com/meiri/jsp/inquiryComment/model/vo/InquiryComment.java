package com.meiri.jsp.inquiryComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class InquiryComment implements Serializable {

	private static final long serialVersionUID = 1001L;
	
	private int cno;		// 답변 코드
	private int inqno;		// 상담 코드
	private String ccontent;// 답변 내용
	private String userId;  // 작성자(관리자 혹은 질문자)
	private Date cdate;		// 답변 날짜
	
	public InquiryComment() {
		super();
	}
	
	public InquiryComment(int cno, int inqno, String ccontent, String cwriter, String userId, Date cdate, int refcno,
			int clevel) {
		super();
		this.cno = cno;
		this.inqno = inqno;
		this.ccontent = ccontent;
		this.userId = userId;
		this.cdate = cdate;
	}
	
	public InquiryComment(int inqno, String ccontent, String userId) {
		super();
		this.inqno = inqno;
		this.ccontent = ccontent;
	}

	@Override
	public String toString() {
		return "BoardComment [cno=" + cno + ", inqno=" + inqno + ", ccontent=" + ccontent
				+ ", userId=" + userId + ", cdate=" + cdate + "]";
	}
	
	public int getInqno() {
		return inqno;
	}
	public void setInqno(int inqno) {
		this.inqno = inqno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	
}
