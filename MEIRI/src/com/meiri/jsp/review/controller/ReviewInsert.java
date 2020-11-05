package com.meiri.jsp.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.meiri.jsp.common.MyRenamePolicy;
import com.meiri.jsp.productFile.model.vo.ProductFile;
import com.meiri.jsp.review.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/insert.re")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달받을 파일의 크기 설정
		int maxSize = 1024 * 1024 * 10; // 10MB
		
		// 2. 멀티파트 전달 확인
		if(! ServletFileUpload.isMultipartContent(request)) {
					
			request.setAttribute("exception",new Exception("사진 게시글 등록 오류"));
			request.setAttribute("error-msg", "멀티파트 전송이 아니네요");
					
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	}
		
		// 3. 저장할 경로 설정
		String root = request.getServletContext().getRealPath("/resources");
		String savePath = root + "/ReviewUploadFiles/";
		
		// 4. 멀티파트 객체 준비
		MultipartRequest mre = new MultipartRequest(request,savePath, maxSize, "UTF-8", new MyRenamePolicy() );
		
		// 다중 파일 업로드 처리하기
				// 원본 파일 명과 변경된 파일 명 담기
				ArrayList<String> originNames = new ArrayList<>();
				ArrayList<String> changeNames = new ArrayList<>();
				
				// 화면에서 전달한 파일 이름 가져오기
				// Enumeration: 목록화 하거나 특정 목록 나열할 때 사용하는 객체
				Enumeration<String> files = mre.getFileNames();
				
				while(files.hasMoreElements()) {
					// 가져온 파일 하나씩 꺼내옴
					String tagName = files.nextElement();
					
					originNames.add(mre.getOriginalFileName(tagName));
					changeNames.add(mre.getFilesystemName(tagName));
					
					/*
					 * System.out.println("tagname : "+tagName);
					 * System.out.println(originNames);
					 * System.out.println(changeNames);
					 */
				}
		
		Review r = new Review();
		
		r.setRcontent(mre.getParameter("content"));
		r.setUserid(mre.getParameter("userId"));
		r.setUserid(mre.getParameter("userId"));
		
		// Attachment 객체 생성 후 파일 정보 저장하기
		ArrayList<ProductFile> list = new ArrayList<>();
				
		// 리스트에 파일 목록을 하나씩 저장
		for(int i = originNames.size() -1; i>=0; i--) {
			// 기존에 역순으로 가져온 파일들을 올바른 순서로 재정렬하는 반복문
			ProductFile pf = new ProductFile();
					
			pf.setFilepath(savePath);
			pf.setOriginname(originNames.get(i));
			pf.setChangename(changeNames.get(i));
					
			list.add(pf);
		}
		
		
		
		// 제품 번호, 리뷰 내용, 회원 아이디, 파일
		String userid = request.getParameter("userId");
		String rcontent = request.getParameter("rcontent");
		int pcode = Integer.parseInt(request.getParameter("pcode"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
