package com.meiri.jsp.member.model.dao;

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

import com.meiri.jsp.member.model.vo.Member;


public class MemberDAO {
	
	private Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		
		String filePath = MemberDAO.class
								  .getResource("/config/member-sql.properties")
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

	public ArrayList<Member> selectList(int currentPage, int limit, Connection con) {
		
		ArrayList<Member> rlist = new ArrayList<>();
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
				
				Member m = new Member();
							
				m.setUserid(	rset.getString("userid")	);
				m.setPassword(	rset.getString("password")	);
				m.setName(		rset.getString("name")		);
				m.setAddress(	rset.getString("address")	);
				m.setEmail(		rset.getString("email")		);
				m.setBirth(		rset.getDate("birth")		);
				m.setPhone(		rset.getString("phone")		);
				
				rlist.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}

	public Member selectOne(String userid, Connection con) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				m = new Member();
				
				m.setUserid(	rset.getString("userid")	);
				m.setPassword(	rset.getString("password")	);
				m.setName(		rset.getString("name")		);
				m.setAddress(	rset.getString("address")	);
				m.setEmail(		rset.getString("email")		);
				m.setBirth(		rset.getDate("birth")		);
				m.setPhone(		rset.getString("phone")		);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return m;
	}

	public int deleteMember(String userid, Connection con) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}
}
