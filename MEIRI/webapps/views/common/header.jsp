<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(주)메이리</title>

<style>

</style>

</head>

<body>

	<div class="wrap">
		<ul class="nav">
			<li class="menu">HOME</li>
			<li class="menu">제품정보</li>
			<li class="menu"><a href="/myWeb/views/introduction/introductionCompany.jsp">본사소개</a></li>
			<li class="menu"><a href="/myWeb/views/directions/directions.jsp">오시는길</a></li>
			<li class="menu"><a href="/myWeb/views/mypage/mypage.jsp">마이페이지</a></li>
		</ul>
	</div>
	
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="">자주묻는질문</div>
			<div class="menu" onclick="">공지사항</div>
			<div class="menu" onclick="">Q&amp;A</div>
			<div class="menu" onclick="">MYPAGE</div>
		</div>
	</div>
	
		<script>
		function goHome(){ 		//자주묻는질문
			location.href="";
		}
		function goNotice(){ 	//공지사항
			location.href="";
		}
		function goBoard(){ 	//Q & A
			location.href="";
		}
		function goMypage(){	//mypage 홈 
			location.href="";
		}
	</script>
	
</body>

</html>