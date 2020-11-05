package com.meiri.jsp.product.model.service;

import static com.meiri.jsp.common.JDBCTemplate.close;
import static com.meiri.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.meiri.jsp.product.model.dao.ProductDAO;
import com.meiri.jsp.product.model.vo.Product;

public class ProductService {
	private Connection con;
	private ProductDAO pDAO = new ProductDAO();
	
	
	public int getListCount() {
		
		con = getConnection();
		
		int result = pDAO.getListCount(con);
		
		close(con);
		
		return result;
	}


	public ArrayList<Product> selectList(int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Product> list = pDAO.selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}


	public Product selectOne(int pno) {
		con = getConnection();
		
		Product n = pDAO.selectOne(con, pno);
		
		close(con);
		
		return n;
	}


	public int insertProduct(Product p, String pmc, String aid) {
		
		con = getConnection();
		
		int result = pDAO.insertProduct(con, p, pmc, aid);
		
		close(con);
		
		return result;
	}


	public int updateProduct(Product p, String pmc, String aid) {
		
		con = getConnection();
		
		int result = pDAO.updateProduct(con, p, pmc, aid);
		
		close(con);
		
		return result;
	}


	public int deleteProduct(int pno, String pmc, String aid) {
		con = getConnection();
		
		int result = pDAO.deleteProduct(con, pno, pmc, aid);
		
		close(con);
		
		return result;
	}

}
