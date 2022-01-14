<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 값 변경</title>
</head>
<body>
<%
	// 쿠키 정보 읽기
	Cookie[] cookies = request.getCookies();
	if(cookies!=null && cookies.length>0) {
		for(int i=0;i<cookies.length;i++) {
			// 쿠키 값을 변경할 쿠키가 존재하는지 확인
			if(cookies[i].getName().equals("name")) { // 쿠키명이 name인 쿠키 검색
				// 동일한 이름으로 쿠키 생성
				Cookie cookie = new Cookie("name", URLEncoder.encode("JSP 프로그래밍", "UTF-8"));
				// 생성한 쿠키를 클라이언트에 전송
				response.addCookie(cookie);
				
				out.println("name 쿠키의 값을 변경합니다.");
			}
		}
	}
	else {
		out.println("쿠키가 존재하지 않습니다.");
	}
%>
</body>
</html>