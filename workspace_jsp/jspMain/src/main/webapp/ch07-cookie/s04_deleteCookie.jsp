<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
<%
	// 쿠키 읽기
	Cookie[] cookies = request.getCookies();
	// 쿠키 존재 여부 확인
	if(cookies!=null && cookies.length>0) {
		for(int i=0;i<cookies.length;i++) {
			// 삭제할 쿠키가 있는지 확인
			if(cookies[i].getName().equals("name")) {
				// 삭제할 쿠키와 동일한 이름의 쿠키를 생성
				Cookie cookie = new Cookie("name", ""); // 삭제할 것이므로 value는 어떤 값이든 무관
				cookie.setMaxAge(0); // 쿠키 정보 제거
				
				// 생성된 쿠키를 클라이언트로 전송
				response.addCookie(cookie);
				
				out.println("name 쿠키를 삭제하였습니다.");
			}
		}
	}
	else {
		out.println("쿠키가 존재하지 않습니다"); // 쿠키 배열이 만들어지지 않았거나, 쿠키 배열이 만들어졌지만 배열 안에 쿠키가 없는 경우
	}
%>
</body>
</html>