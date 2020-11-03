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
 * Servlet implementation class ProductUpdate
 */
@WebServlet("/update.pr")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 코드, 변경할 이름, 가격, 타입, 색상
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String type = request.getParameter("type");
		String color = request.getParameter("color");
		
		ProductService ns = new ProductService();
		
		Product p = ns.selectOne(pno);
		
		p.setPname(name);
		p.setPprice(price);
		p.setPtype(type);
		p.setPcolor(color);
		
		int result = ns.updateProduct(p);
		
		
		if( result > 0) {
			response.sendRedirect("productList.pr");
		} else {
			request.setAttribute("error-msg", "자주 묻는 질문 수정 실패!");
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
