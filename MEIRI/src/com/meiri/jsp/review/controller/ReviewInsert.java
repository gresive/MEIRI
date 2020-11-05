package com.meiri.jsp.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/insert.re")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 번호, 리뷰 내용, 회원 아이디, 파일
		  String writer = request.getParameter("writer");
	      String rcontent = request.getParameter("rcontent");
	      int pcode = Integer.parseInt(request.getParameter("pcode"));
		
	      
	    /* 커밋 후 수정 쓰지 마세요~~~~~~~
		ReviewInesrt = new ReviewInsert(bno, content, writer, refcno, clevel);
		
		int result = new BoardCommentService().insertComment(comment);
		
		if( result > 0 ) {
			response.sendRedirect("selectOne.bo?bno="+ bno);
		} else {
			// 에러 페이지 작성 . . . 생략
		}
		
	}
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
