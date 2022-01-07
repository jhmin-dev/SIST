<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 리다이렉트시 생략 가능한 영역 시작 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.sendRedirect() 테스트</title>
</head>
<body>
현재 페이지는 s09_responseA.jsp 입니다. 화면에 보여지지 않습니다.
</body>
</html>
<%-- 리다이렉트시 생략 가능한 영역 끝 --%>
<%
	// response.sendRedirect("/jspMain/ch03-nestedObject/s10_responseB.jsp"); // 이동할 페이지의 경로를 Context Root부터 명시
	response.sendRedirect("s10_responseB.jsp"); // 이동할 페이지가 같은 경로에 있으면 파일명만 명시 가능
%>