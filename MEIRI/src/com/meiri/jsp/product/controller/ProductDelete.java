package com.meiri.jsp.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meiri.jsp.product.model.service.ProductService;

/**
 * Servlet implementation class QuestionDelete
 */
@WebServlet("/delete.pr")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String pmcontent =  request.getParameter("content");
		
		String adminid = request.getParameter("aid");
		//!!!!!!! JSP 만들때 경로 뒤에 ?aid=<%=a.getAdminid()%> 로 하기
		//!!!!!!! a 는 Admin 객체, 변경될 수 있음
		
		int result = new ProductService().deleteProduct(pno, pmcontent, adminid);
		
		if( result > 0) {
			response.sendRedirect("Product.pr");
		} else {
			request.setAttribute("error-msg", "공지사항 삭제 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
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
