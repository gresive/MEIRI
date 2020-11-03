package com.meiri.jsp.member.model.service;

import static com.meiri.jsp.common.JDBCTemplate.close;
import static com.meiri.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.meiri.jsp.member.model.dao.MemberDAO;
import com.meiri.jsp.member.model.vo.Member;

public class MemberService {

	private Connection con;
	private MemberDAO mdao = new MemberDAO();
	
public int getListCount() {
		
		con = getConnection();
		
		int result = mdao.getListCount(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Member> selectList(int currentPage, int limit) {
		
		con = getConnection();
		
		ArrayList<Member> m = mdao.selectList(currentPage, limit, con);
		
		close(con);
		
		return m;
	}

	public Member selectOne(int mno) {

		con = getConnection();
		
		Member m = mdao.selectOne(mno, con);
		
		close(con);
		
		return m;
	}

	public int deleteMember(int mno) {
		
		con = getConnection();
		
		int result = mdao.deleteMember(mno, con);
		
		close(con);
		
		return result;
	}
}
