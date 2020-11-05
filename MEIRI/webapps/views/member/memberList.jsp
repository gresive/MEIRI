<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.meiri.jsp.member.model.vo.*, java.util.*" %>
<%@ page import="com.meiri.jsp.common.PageInfo" %>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
	.outer{
		width:900px;
		height:600px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table {
		padding : 20px;
		border:1px solid white;
		text-align:center;
	}
	.tableArea {
		width:750px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>


	<div class="outer">
		<br>
		<h2 align="center">회원 목록</h2>
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<th width="100px">이 름</th>
					<th width="100px">아이디</th>					
					<th width="200px">이메일</th>					
					<th width="150px">생년월일</th>					
					<th width="150px">연락처</th>
				</tr>
				<% for(Member b : list) { %>
				<tr>
					<!-- 공지사항 DB테이블 보고 만들 예정 -->
					<input type="hidden" value="<%= b.getUserid() %>">
					<td><%= b.getName() %></td>
					<td><%= b.getUserid() %></td>
					<td><%= b.getEmail() %></td>
					<td><%= b.getBirth() %></td>
					<td><%= b.getPhone() %></td>
				</tr>
				<% } %>
			</table>
		</div>
		
		<%-- 페이지 처리 코드 넣기 --%>
		
		<div class="pagingArea" align="center">
		
		<button onclick="location.href='<%= request.getContextPath() %>/memberList.me?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/memberList.me?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/memberList.me?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/memberList.me?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/memberList.me?currentPage=<%= maxPage %>'">>></button>
		
		</div>
		
		<div class="btnArea" align="center">
			
			<br><br>
				
				<script>
					$(function(){
						$('#listArea td').mouseenter(function(){
							$(this).parent().css({"background" : "grey", "cursor" : "pointer"});
						}).mouseout(function(){
							$(this).parent().css({"background" : "black"});
						}).click(function(){
							var userid = $(this).parent().find('input').val();
							location.href = "<%= request.getContextPath() %>/memberOne.me?userid=" + userid;
																		
						});
					});
				</script>
					
		</div>
		
	</div>


</body>
</html>





