<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDAO" %>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" class="kr.member.vo.MemberVO"/>
<jsp:setProperty property="*" name="member"/>
<%
	MemberDAO dao = MemberDAO.getInstance();
	dao.insertMember(member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>회원 가입 완료</h1>
	<div class="result-display">
		<div class="align-center">
			회원 가입 성공!<br>
			<button type="button" onclick="location.href = 'main.jsp';">홈으로</button>
		</div>
	</div>
</div>
</body>
</html>