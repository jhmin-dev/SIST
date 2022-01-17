<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDAO" %>
<%
	Integer user_num = (Integer)session.getAttribute("user_num");
	if(user_num==null) { // 로그인되어 있지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}
	else { // 로그인되어 있는 경우
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" class="kr.member.vo.MemberVO"/>
<jsp:setProperty property="*" name="member"/>
<%
		// num이 전송되지 않았기 때문에 session에 저장된 num을 이용
		member.setNum(user_num);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 완료</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>회원 정보 수정 완료</h1>
	<div class="result-display">
		<div class="align-center">
			회원 정보 수정 완료!<br>
			<button type="button" onclick="location.href = 'myPage.jsp';">myPage</button>
			<button type="button" onclick="location.href = 'main.jsp';">홈으로</button>
		</div>
	</div>
</div>
</body>
</html>
<%
	}
%>