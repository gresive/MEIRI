package com.meiri.jsp.member.model.service;

import static com.meiri.jsp.common.JDBCTemplate.*;


import java.sql.Connection;

import com.meiri.jsp.common.exception.MemberException;
import com.meiri.jsp.member.model.dao.MemberDAO;
import com.meiri.jsp.member.model.vo.Member;

public class MemberService {
	// 1. 찾아갈 데이터베이스 객체 선언
		private Connection con;
		private MemberDAO mDAO = new MemberDAO();
		
		public Member selectMember(Member m) {
			
			con = getConnection();
			
			Member result = mDAO.selectMember(con, m);
			
			close(con);
			
			return result;
			
		}

		public int insertMember(Member joinMember) throws MemberException {
			
			con = getConnection();
			int result = mDAO.insertMember(con, joinMember);
			
			if( result > 0 ) { // 회원 가입 성공!
				commit(con);
			} else {           // 회원 가입 실패...
				rollback(con);
			}
			
			close(con);
			
			return result;
		}

		public int updateMember(Member m) throws MemberException { 
			con = getConnection(); 
			
			int result = mDAO.updateMember(con, m); 
			
			if(result > 0) { 
				commit(con);
			} else {
				rollback(con);
			} 
			
			close(con);
			
			return result;
		}

		public int deleteMember(String userId) throws MemberException {
			
			con = getConnection();
			
			int result = mDAO.deleteMember(con, userId);
			
			if( result > 0 ) {
				commit(con);
			} else {
				rollback(con);
			}
			
			close(con);
			
			return result;
		}

		public int idDupCheck(String id) {
			con = getConnection();
			
			int result = mDAO.idDupCheck(con, id);
			
			close(con);
			
			return result;
		}
		
		
	}


