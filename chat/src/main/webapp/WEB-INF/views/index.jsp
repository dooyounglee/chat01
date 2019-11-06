<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">

		아이디 : <input type="text" name="id" id="id">
		비번 : <input type="password" name="pass" id="pass">
		<button type="submit">로그인</button>
		<button type="reset">취소</button>
	</form>
	
	<button onclick="location.href='join.do'">가입</button>
</body>
</html>