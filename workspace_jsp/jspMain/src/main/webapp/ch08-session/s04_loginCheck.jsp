<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 여부 검사</title>
</head>
<body>
<%
	String user_id = (String)session.getAttribute("user_id"); // getAttribute() 메서드는 속성 값을 Object 자료형으로 반환하므로 다운캐스팅 필요
	if(user_id!=null) { // 로그인된 경우
%>
	아이디 [ <%= user_id %> ]로 로그인한 상태!<br>
	<input type="button" value="로그아웃" onclick="location.href='s05_logout.jsp'">
<%		
	}
	else { // 로그인되지 않은 경우
%>
	로그인하지 않은 상태<br>
	<input type="button" value="로그인" onclick="location.href='s02_loginForm.jsp'">
<%	
	}
%>
</body>
</html>