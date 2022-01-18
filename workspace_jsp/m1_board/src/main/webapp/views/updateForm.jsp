<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO board = dao.getBoard(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('update_form').onsubmit = function() {
			let list = document.getElementsByTagName('li');
			for(let i=0;i<list.length;i++) {
				let input = list[i].querySelector('input,textarea');
				input.value = input.value.trim();
				if(!input.value) {
					let word = list[i].querySelector('label').textContent;
					let post = (word.charCodeAt(word.length-1) - '가'.charCodeAt(0)) % 28 > 0 ? '을' : '를';
					alert(word + post + ' 입력하세요!');
					input.focus();
					return false;
				}
			}
		};
	};
</script>
</head>
<body>
<div class="page-main">
	<h1>글 수정</h1>
	<form id="update_form" action="update.jsp" method="post">
		<input type="hidden" name="num" value="<%= board.getNum() %>"> <%-- 회원 번호와 달리 글 번호는 세션에 저장하지 않으므로 type="hidden"으로 전달 --%>
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="<%= board.getTitle() %>" size="30" maxlength="50">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" value="<%= board.getName() %>" size="10" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="10" maxlength="12"> <%-- 비밀번호는 수정 대상이 아니라, 인증용 --%>
				* 글 등록시 입력한 비밀번호
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"><%= board.getContent() %></textarea> <%-- <textarea> 태그의 미리보기는 (value 속성이 아니라) 시작 태그와 끝 태그 사이에, 공백 없이 명시 --%>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글 수정">
			<input type="button" value="이전" onclick="history.go(-1);">
			<input type="button" value="목록" onclick="location.href = 'list.jsp';">
		</div>
	</form>
</div>
</body>
</html>