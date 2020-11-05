package com.meiri.jsp.review.model.service;

import static com.meiri.jsp.common.JDBCTemplate.close;

import java.sql.Connection;

import com.meiri.jsp.review.model.dao.ReviewDAO;

public class ReviewService {
	
	private Connection con;
	private Review rDAO = new ReviewDAO();
	
	
	public ArrayList<Review> selectList() {
		con = getConnection();
		
		ArrayList<Thumbnail> list = tDAO.selectList(con);
		
		close(con);
		
		
		return list;
	}


	public int insertThumbnail(Thumbnail t, ArrayList<Attachment> list) {
		con = getConnection();
		
		int result = 0;
		
		// 저장해야 될 것 이 두 가지 ( 사진 게시글 , 첨부파일 여러 개) 
		// 1. 사진 게시글 저장
		int result1 = tDAO.insertThumbnail(con, t);
		
		if(result1 > 0) {
			int bno = tDAO.getCurrentBno(con);
			System.out.println(bno);
			
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setBno(bno);
			}
		}
		
		// 2. 첨부파일 여러 개 저장
		int result2 = 0;
		for(int i = 0; i < list.size(); i++) {
			// 첫번째 이미지는 대표 이미지 (flevel = 0)
			// 나머지는 서브이미지 (flevel = 1)로 설정한다. 
			
			list.get(i).setFlevel(i == 0 ? 0 : 1);
			
			result2 = tDAO.insertAttachment(con,  list.get(i));
			
			if( result2 == 0) {
				break; // 잘못 실행된 행이 있다면 반복(insert) 취소! 
			} 
			
			
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		
		
		return result;
	}
	
	
	
}
