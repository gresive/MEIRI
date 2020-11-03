package com.meiri.jsp.review.model.dao;

import static com.meiri.jsp.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.meiri.jsp.review.model.vo.Review;

public class ReviewDAO {
	private Properties prop;
	
	public ReviewDAO() {
		prop = new Properties();
		
		String filePath = ReviewDAO.class
								  .getResource("/config/review-sql.properties")
				                  .getPath(); // DB 완성 후 작성
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int getListCount(Connection con) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 이거 DB 완성 후 작성
		String sql = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Review> selectList(int currentPage, int limit, Connection con) {
		
		ArrayList<Review> rlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 이거 DB 완성 후 작성
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			// 1. 마지막 행의 번호
			// 2. 첫 행의 번호
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;

			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setRno(		rset.getInt("rno")			);				
				r.setRtitle(	rset.getString("rtitle")	);
				r.setRcontent(	rset.getString("rcontent")	);
				r.setRdate(		rset.getDate("rdate")		);
				r.setRstar(		rset.getInt("rstar")		);
				r.setUserid(	rset.getString("userid")	);
				
				rlist.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}

	public Review selectOne(int rno, Connection con) {
		
		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, rno);
			
			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				r = new Review();
				
				r.setRno(		rset.getInt("rno")			);				
				r.setRtitle(	rset.getString("rtitle")	);
				r.setRcontent(	rset.getString("rcontent")	);
				r.setRdate(		rset.getDate("rdate")		);
				r.setRstar(		rset.getInt("rstar")		);
				r.setUserid(	rset.getString("userid")	);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return r;
	}

	public int deleteReview(int rno, Connection con) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}
}
