package com.meiri.jsp.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.meiri.jsp.review.model.dao.ReviewDAO;
import com.meiri.jsp.review.model.vo.Review;

import static com.meiri.jsp.common.JDBCTemplate.*;

public class ReviewService {
	
	private Connection con;
	private ReviewDAO rdao = new ReviewDAO();
	
	public int getListCount() {
		
		con = getConnection();
		
		int result = rdao.getListCount(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Review> selectList(int currentPage, int limit) {
		
		con = getConnection();
		
		ArrayList<Review> r = rdao.selectList(currentPage, limit, con);
		
		close(con);
		
		return r;
	}

	public Review selectOne(int rno) {

		con = getConnection();
		
		Review r = rdao.selectOne(rno, con);
		
		close(con);
		
		return r;
	}

	public int deleteReview(int rno) {
		
		con = getConnection();
		
		int result = rdao.deleteReview(rno, con);
		
		close(con);
		
		return result;
	} 
	
}
