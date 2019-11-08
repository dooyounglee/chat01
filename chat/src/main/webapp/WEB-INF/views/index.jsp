<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@beta/dist/js.cookie.min.js"></script>
</head>
<body>
${cookie }

	<form action="login.do" method="post">

		아이디 : <input type="text" name="id" id="id"><br>
		비번 : <input type="password" name="pass" id="pass"><button type="submit">로그인</button><br>
		<input type="checkbox" name="remember">자동로그인 | <input type="checkbox" id="idSaveCheck"> 아이디/비번 기억하기<br>
		<button type="reset">취소</button>
	</form>
	<script>
	$("#id").val(Cookies.get('id'));      
	$("#pass").val(Cookies.get('pass'));      
    if($("#id").val() != ""){
        $("#idSaveCheck").attr("checked", true);
    }
    
    $("#idSaveCheck").change(function(){
        if($("#idSaveCheck").is(":checked")){
            Cookies.set('id', $("#id").val(), { expires: 7 });
            Cookies.set('pass', $("#pass").val(), { expires: 7 });
        }else{
              Cookies.remove('id');
              Cookies.remove('pass');
        }
    });
    
    $("#id,#pass").keyup(function(){
        if($("#idSaveCheck").is(":checked")){
            Cookies.set('id', $("#id").val(), { expires: 7 });
            Cookies.set('pass', $("#pass").val(), { expires: 7 });
        }
    });
	</script>
	
	<button onclick="location.href='join.do'">가입</button>
</body>
</html>