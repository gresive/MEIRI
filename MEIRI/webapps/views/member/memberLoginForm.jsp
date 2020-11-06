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




<form id="login" action="/meiri/login.me" method="post" >
<table align="center">

<tr>
 <td width="200px">아이디</td>
 <td><input type="text" name="userId" id="userId" required="required"></td>
</tr>
<tr>
 <td>비밀번호</td>
 <td><input type="password" id="password" name="password" required="required"></td>
</tr>

</table>

<input type="submit" value="로그인"> &emsp;
<input type="button" value="회원가입" onclick="location.href='memberJoinForm.jsp'">


</form>

</body>
</html>