<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.web.member.MemberVO" %>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	// 자바빈 생성
	MemberVO member = new MemberVO();
	// 전송된 데이터를 request로부터 추출해서 setter 메서드를 이용해 자바빈의 프로퍼티에 저장
	member.setId(request.getParameter("id"));
	member.setPassword(request.getParameter("password"));
	member.setName(request.getParameter("name"));
	member.setEmail(request.getParameter("email"));
	member.setAddress(request.getParameter("address"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h3>회원 정보 보기</h3>
아이디 : <%= member.getId() %><br>
비밀번호 : <%= member.getPassword() %><br>
이름 : <%= member.getName() %><br>
이메일 : <%= member.getEmail() %><br>
주소 : <%= member.getAddress() %>
</body>
</html>