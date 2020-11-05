<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>

<style>

	body{
 	text-align: center; 
	}
	
	#btn1{ width:200px; height:160px; } 
	#btn2{ width:200px; height:160px; } 
	#btn3{ width:200px; height:160px; } 
	#btn4{ width:200px; height:160px; } 
	#btn_group button{ border: 1px solid skyblue; background-color: rgba(0,0,0,0); color: skyblue; padding: 5px; margin:auto;} 
	#btn_group button:hover{ color:white; background-color: skyblue; }
	
	aside{width:100px;background:pink}
	aside ul{list-style:none;padding:0}
	aside ul li{clear:both;float:left;margin-top:10px}
	
	<!-- ------------------------------------------------- -->
	
	body {
        margin:20px auto;
        padding: 0;
        font-family:"맑은 고딕";
        font-size:0.9em;
	}
	    ul#navi {
	        width: 200px;
	        text-indent: 10px;
	}
	    ul#navi, ul#navi ul {
	        margin:0;
	        padding:0;
	        list-style:none;
	}
	    li.group {
	        margin-bottom: 3px;
	}
	    li.group div.title {
	        height: 35px;
	        line-height: 35px;
	        background:#9ab92e;
	        cursor:pointer;
	}
	    ul.sub li {
	        margin-bottom: 2px;
	        height:35px;
	        line-height:35px;
	        background:#f4f4f4;
	        cursor:pointer;
	}
	    ul.sub li a {
	        display: block;
	        width: 100%;
	        height:100%;
	        text-decoration:none;
	        color:#000;
	}
	    ul.sub li:hover {
	        background:#cf0;
	}
	
</style>

</head>

<body>

	<%@ include file="/views/common/header.jsp" %> <!-- header 삽입 -->
	<br />
	
	
	<div id="btn_group">	<!-- onclick 추가 -->
		<button id="btn1" onclick="">F&A<br><span>자주묻는질문</span></button> 
		<button id="btn2" onclick="">Q&A<br><span>질문과 답변</span></button>
		<button id="btn3" onclick="">NOTICE<br><span>공지사항</span></button> 
		<button id="btn4" onclick="">MYPAGE<br><span>내 정보</span></button>  
	</div>
	
	<!-- -------------------------------------------------------------- -->
	
		
	<ul id="navi">
        <li class="group">
            <div class="title">title 1</div>
            <ul class="sub">
                <li><a href="#">sub1</a></li>
                <li><a href="#">sub1</a></li>
                <li><a href="#">sub1</a></li>
                <li><a href="#">sub1</a></li>
            </ul>
        </li>
    </ul>
	
	
	
		
	<br /><br />
	
	<%@ include file="/views/common/footer.jsp" %> <!-- footer 삽입 -->
	
</body>


</html>