<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDAO" %>
<%@ page import="kr.member.vo.MemberVO" %>
<%
	Integer user_num = (Integer)session.getAttribute("user_num");
	if(user_num==null) { // 로그인되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}
	else { // 로그인되어 있는 경우
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('modify_form').onsubmit = function() {
			var name = document.getElementById('name');
			if(name.value.trim()=='') {
				alert('이름을 입력하세요!');
				name.value = '';
				name.focus();
				return false;
			}
			var passwd = document.getElementById('passwd');
			if(passwd.value.trim()=='') {
				alert('비밀번호를 입력하세요!');
				passwd.value = '';
				passwd.focus();
				return false;
			}
			var email = document.getElementById('email');
			if(email.value.trim()=='') {
				alert('이메일을 입력하세요!');
				email.value = '';
				email.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
<%
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO member = dao.getMember(user_num);
	if(member.getPhone()==null) {
		member.setPhone(""); // null 대신 빈 문자열 출력
	}
%>
<div class="page-main">
	<h1>회원 정보 수정</h1>
	<form action="modifyUser.jsp" method="post" id="modify_form">
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" value="<%= member.getName() %>" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" maxlength="12"> <!-- 수정은 가능하지만 미리보기는 허용하지 않음 -->
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email" value="<%= member.getEmail() %>" maxlength="50">
			</li>
			<li>
				<label for="phone">전화번호</label>
				<input type="text" name="phone" id="phone" value="<%= member.getPhone() %>" maxlength="15">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="홈으로" onclick="location.href = 'main.jsp';">
		</div>
	</form>
</div>
</body>
</html>
<%
	}
%>