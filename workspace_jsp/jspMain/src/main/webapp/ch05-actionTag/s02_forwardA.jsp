<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전송된 데이터 인코딩 처리; <jsp:param/>으로 파라미터 전송시, request에 처음 액세스하는 것은 forward된 JSP 파일이 아니라 forward하는 JSP 파일이므로 인코딩 방식 설정도 forward하는 JSP 파일에서 해야 전송되는 파라미터 값이 깨지지 않음
	request.setCharacterEncoding("UTF-8");
%>
<%-- 포워드시 생략 가능한 영역 시작 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드 테스트</title>
</head>
<body>
forwardA.jsp 페이지! 화면은 보여지지 않습니다.
</body>
</html>
<%-- 포워드시 생략 가능한 영역 끝 --%>
<jsp:forward page="s03_forwardB.jsp">
	<jsp:param value="오렌지" name="color"/>
</jsp:forward>