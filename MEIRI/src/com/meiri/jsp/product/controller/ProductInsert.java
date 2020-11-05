package com.meiri.jsp.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meiri.jsp.product.model.service.ProductService;
import com.meiri.jsp.product.model.vo.Product;

/**
 * Servlet implementation class QuestionInsert
 */
@WebServlet("/insert.pr")
public class ProductInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 제품명, 가격, 타입, 색상
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String type = request.getParameter("type");
		String color = request.getParameter("color");
		
		String adminid = request.getParameter("aid");
		//!!!!!!! JSP 만들때 경로를 /insert.pr?aid=<%=a.getAdminid()%> 로 하기
		//!!!!!!! a 는 Admin 객체, 변경될 수 있음
		
		String pmcontent = request.getParameter("content");
		
		Product p = new Product(name, price, type, color);
		
		int result = new ProductService().insertProduct(p, pmcontent, adminid);
		
		if (result > 0) {
			response.sendRedirect("productList.pr");
		} else {
			request.setAttribute("error-msg", "게시글 작성 실패!");
			
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
