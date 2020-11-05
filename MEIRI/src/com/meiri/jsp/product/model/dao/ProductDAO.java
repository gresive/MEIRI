package com.meiri.jsp.product.model.dao;

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

import com.meiri.jsp.product.model.vo.Product;

public class ProductDAO {
private Properties prop;
	
	public ProductDAO() {
		prop = new Properties();
		
		String filePath = ProductDAO.class
								  .getResource("/config/product-sql.properties")
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

	public ArrayList<Product> selectList(Connection con, int currentPage, int limit) {
		
		ArrayList<Product> list = new ArrayList<>();
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
				
				Product p = new Product();
				
				p.setPno(      	rset.getInt("pcode"));
				p.setPname(  	rset.getString("pname"));
				p.setPprice(   	rset.getInt("price"));
				p.setPtype(		rset.getString("ptype"));
				p.setPcolor( 	rset.getString("pcolor"));
				
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}	
		
		return list;
	}

	public Product selectOne(Connection con, int nno) {
		
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 이거 DB 완성 후 작성
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				p = new Product();
				
				p.setPno(      	rset.getInt("pcode"));
				p.setPname(  	rset.getString("pname"));
				p.setPprice(   	rset.getInt("price"));
				p.setPtype(		rset.getString("ptype"));
				p.setPcolor( 	rset.getString("pcolor"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return p;
	}

	public int insertProduct(Connection con, Product p, String pmc, String aid) {
		
		int result = 0;
		int result1 = 0;
		
		PreparedStatement pstmt = null;
		
		String sql1 = prop.getProperty("insertProduct");

		
		try {
			pstmt = con.prepareStatement(sql1);
			
			pstmt.setString( 1, p.getPname());
			pstmt.setInt(	 2, p.getPprice());
			pstmt.setString( 3, p.getPtype());
			pstmt.setString( 4, p.getPcolor());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		int result2 = 0;
		String sql2 = prop.getProperty("insertPmanage");
		
		if(result1 > 0) {
		
			try {
				pstmt = con.prepareStatement(sql2);
				
				pstmt.setString(1, aid);
				pstmt.setInt(	2, p.getPno());
				pstmt.setString(3, pmc);
				
				
				result2 = pstmt.executeUpdate();
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		
		result = result1 * result2;
		
		return result;
	}

	public int updateProduct(Connection con, Product p, String pmc, String aid) {
		
		int result = 0;
		int result1 = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString( 1, p.getPname());
			pstmt.setInt(	 2, p.getPprice());
			pstmt.setString( 3, p.getPtype());
			pstmt.setString( 4, p.getPcolor());
			pstmt.setInt(	 5, p.getPno());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		int result2 = 0;
		String sql2 = prop.getProperty("insertPmanage");
		
		if(result1 > 0) {
		
			try {
				pstmt = con.prepareStatement(sql2);
				
				pstmt.setString(1, aid);
				pstmt.setInt(	2, p.getPno());
				pstmt.setString(3, pmc);
				
				
				result2 = pstmt.executeUpdate();
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		
		result = result1 * result2;
		
		return result;
	}

	public int deleteProduct(Connection con, int pno, String pmc, String aid) {
		
		int result = 0;
		int result1 = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		int result2 = 0;
		String sql2 = prop.getProperty("insertPmanage");
		
		if(result1 > 0) {
		
			try {
				pstmt = con.prepareStatement(sql2);
				
				pstmt.setString(1, aid);
				pstmt.setInt(	2, pno);
				pstmt.setString(3, pmc);
				
				
				result2 = pstmt.executeUpdate();
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		
		result = result1 * result2;
		
		return result;
	}
}
