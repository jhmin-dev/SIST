<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	// 쿠키 생성; Cookie 클래스는 서블릿에 포함되어 있어 별도로 import할 필요 없음
	Cookie cookie = new Cookie("name", URLEncoder.encode("너굴", "UTF-8")); // 생성자의 첫 번째 인자는 쿠키명, 두 번째 인자는 쿠키 값이며 한글 포함시 깨지지 않게 인코딩해서 인자로 전달해야 함
	
	// 쿠키 유효 시간 지정(단위: 초)
	// cookie.setMaxAge(30*60); // 쿠키 유효 시간을 지정하면 클라이언트 영역에 파일을 생성해서 쿠키 정보 보관
	// cookie.setMaxAge(-1); // 쿠키 유효 시간을 지정하지 않거나 -1로 지정시 메모리에 쿠키 정보 보관(=브라우저 종료시 쿠키 만료)
	
	// 생성된 쿠키를 클라이언트에 전송
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
<%= cookie.getName() %> 쿠키의 값은 <%= cookie.getValue() %>
</body>
</html>