package com.meiri.jsp.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meiri.jsp.review.model.service.ReviewService;
import com.meiri.jsp.review.model.vo.Review;

/**
 * Servlet implementation class ReviewSelectOne
 */
@WebServlet("/reviewOne.re")
public class ReviewSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		Review r = new ReviewService().selectOne(rno);
		
		String page = "";
		
		if( r != null ) {
			request.setAttribute("review", r);
			
			page = "views/review/reviewDetail.jsp";
		} else {
			
			request.setAttribute("error-msg", "게시글 상세조회 실패!");
			
			page = "views/common/errorPage.jsp";
			
		}
		
		request.getRequestDispatcher(page)
		       .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
