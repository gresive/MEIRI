package com.meiri.jsp.review.model.dao;

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


import static com.meiri.jsp.common.JDBCTemplate.close;

public class ReviewDAO {
	
	private Properties prop = null;
	
	public ReviewDAO() {
		prop = new Properties();
		
		String filePath = ReviewDAO.class
									  .getResource("config/review-sql.properties")
									  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertReview(Connection con, Review r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, r.getRcontent());
			pstmt.setString(2, r.getUserid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
				
		return result;
	}

	public ArrayList<Review> selectList(Connection con) {
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setUserid(rset.getString("userId"));
				r.setRcontent(rset.getString("rcontent"));
				
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
		
		
		
		
	}

}
