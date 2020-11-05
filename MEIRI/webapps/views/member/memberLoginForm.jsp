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

<br /><br /><br /><br /><br />

<div class="titleArea" align="center">
<h1>Login</h1>
</div>

<tr>

 <td align="center"><input type="text" name="userId" id="userId" required="required"
      placeholder="아이디" ></td>
</tr>
<tr>
 <td align="center"><input type="password" id="password" name="password" required="required"
      placeholder="비밀번호"></td>
</tr>

</table>
<br /><br />

<div align="center">
   <input type="submit" value="로그인" 
    style=padding=50px;> &emsp;
   <input type="button" value="회원가입" 
   onclick="location.href='memberJoinForm.jsp'" >
</div>
</form>

</body>
</html>