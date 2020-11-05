<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<title>로그인</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>



<form id="login" action="/meiri/login.me" method="post" >
<table align="center">

<tr>
 <td width="200px">아이디</td>
 <td><input type="text" name="userId" id="userId" required="required"></td>
</tr>
<tr>
 <td>비밀번호</td>
 <td><input type="password" id="userPwd" name="userPwd" required="required"></td>
</tr>

</table>


<div class="btns" align="center">
				<div id="goMain" onclick="goMain();">메인으로</div>
				<div id="loginBtn" onclick="insertMember();">로그인하기</div>
	</div>

</form>

</body>
</html>