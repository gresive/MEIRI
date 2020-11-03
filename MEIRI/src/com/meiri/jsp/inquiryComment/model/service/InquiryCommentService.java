package com.meiri.jsp.inquiryComment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.meiri.jsp.inquiryComment.model.dao.InquiryCommentDAO;
import com.meiri.jsp.inquiryComment.model.vo.InquiryComment;

import static com.meiri.jsp.common.JDBCTemplate.*;

public class InquiryCommentService {

	private Connection con;
	
	private InquiryCommentDAO inqcDAO = new InquiryCommentDAO();
	
	public int insertComment(InquiryComment comment) {
		con = getConnection();
		
		int result = inqcDAO.insertComment(con, comment);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<InquiryComment> selectList(int bno) {
		con = getConnection();
		
		ArrayList<InquiryComment> clist = inqcDAO.selectList(con, bno);
		
		close(con);
		
		return clist;
	}

	public int updateComment(InquiryComment bco) {
		con = getConnection();
		
		int result = inqcDAO.updateComment(con, bco);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteComment(int cno) {
		con = getConnection();
		
		int result = inqcDAO.deleteComment(con, cno);
		
		if( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}

