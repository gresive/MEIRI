package com.meiri.jsp.review.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meiri.jsp.review.model.service.ReviewService;
import com.meiri.jsp.review.model.vo.Review;



/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/insert.re")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rcode = Integer.parseInt(request.getParameter("rcode"));
		String rcontent = request.getParameter("rcontent");
		String userId = request.getParameter("userId");
		
		Review r = new Review(rcode, rcontent, userId);
		
		int result = new ReviewService().insertReview(r);
		
		if( result > 0 ) {
			response.sendRedirect("meiri/views/product/productDetail.jsp");
		} else {
			// 에러 페이지 작성 . . . 생략
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
