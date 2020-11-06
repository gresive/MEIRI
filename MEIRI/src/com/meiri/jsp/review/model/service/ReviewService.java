package com.meiri.jsp.review.model.service;
import static com.meiri.jsp.common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.ArrayList;


import com.meiri.jsp.review.model.dao.ReviewDAO;
import com.meiri.jsp.review.model.vo.Review;
import com.sun.xml.internal.ws.api.message.Attachment;


import static com.meiri.jsp.common.JDBCTemplate.*;

public class ReviewService {
	
private Connection con;
	
	private ReviewDAO rDAO = new ReviewDAO();
	
	public int insertReview(Review r) {
		con = getConnection();
		
		int result = rDAO.insertReview(con, r);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


//
//	public int deleteReview(int 게시글코드) {
//		con = getConnection();
//		
//		int result = bcDAO.deleteReview(con,게시글번호);
//		
//		if(result>0) {
//			commit(con);
//		} else {
//			rollback(con);
//		} 
//		
//		close(con);
//		
//		return result;
//	}
//	
	
}
